package samsungsw;

import java.io.*;
import java.util.*;

public class Sw_5656 {
    static int n,w,h;
    static int[][] map;
    static LinkedList<Integer> pos;
    static boolean[][] visited;
    static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    static int ans=Integer.MAX_VALUE;

    static void startGame(int[][] gameMap){
        int chance = 0;
        while(chance < n) {
            int targetCol = pos.get(chance);
            int targetRow = 0;
            int power=0;
            for(int i=0; i<h; i++){
                if(gameMap[i][targetCol] != 0){
                    power = gameMap[i][targetCol];
                    targetRow = i;
                    break;
                }
            }
            if(power==0) {
                chance++;
                continue;
            }

            Queue<Brick> reached = new  LinkedList<>();
            reached.add(new Brick(targetRow,targetCol, gameMap[targetRow][targetCol]));
            int ny,nx;
            while(!reached.isEmpty()) {
                Brick temp = reached.poll();
                gameMap[temp.y][temp.x] = 0;
                visited[temp.y][temp.x] = true;
                if(temp.power==1) {
                    continue;
                }
                int dy,dx;
                for (int i = 0; i < 4; i++) {
                    dy = temp.y;
                    dx = temp.x;
                    for (int j = 0; j < temp.power - 1; j++) {
                        ny = dy + dir[i][0];
                        nx = dx + dir[i][1];
                        if (ny >= h || ny < 0 || nx >= w || nx < 0) break;
                        if (!visited[ny][nx] && gameMap[ny][nx] != 0) {
                            visited[ny][nx] = true;
                            reached.add(new Brick(ny, nx,gameMap[ny][nx]));
                        }
                        dy = ny;
                        dx = nx;
                    }
                }
            }

            for(int i=0; i<w; i++){
                Stack<Integer> stk = new Stack<>();
                for(int j=0; j<h; j++){
                    if(gameMap[j][i] != 0){
                        stk.add(gameMap[j][i]);
                        gameMap[j][i] = 0;
                    }
                    visited[j][i] = false;
                }
                if(stk.isEmpty()) continue;
                int idx = h-1;
                while(!stk.isEmpty()){
                    gameMap[idx][i] = stk.pop();
                    idx--;
                }
            }
            chance++;
        }
    }
    static void makePos(int cnt){
        if(cnt==n){
            int[][] gameMap = new int[h][w];
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    gameMap[i][j] = map[i][j];
                }
            }
            visited = new boolean[h][w];
            startGame(gameMap);

            int sum=0;
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(gameMap[i][j] != 0)
                        sum++;
                }
            }
            ans = Math.min(ans,sum);
           //System.out.println(pos);
            return;
        }

        for(int i=0; i<w; i++){
            pos.add(i);
            makePos(cnt+1);
            pos.pollLast();
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());
        int tc=0;
        while(tc++ < testCase){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new int[h][w];
            for(int i=0; i<h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<w; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            pos = new LinkedList<>();
            ans = Integer.MAX_VALUE;
            makePos(0);
            System.out.println("#"+tc+" "+ans);
        }
    }
}
class Brick{
    int y;
    int x;
    int power;
    public Brick(int y, int x, int power){
        this.y=y;
        this.x=x;
        this.power=power;
    }
}