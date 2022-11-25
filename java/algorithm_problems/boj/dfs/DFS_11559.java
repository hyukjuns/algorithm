package boj.dfs;

import java.io.*;
import java.util.ArrayList;
import java.awt.Point;
import java.util.Deque;
import java.util.LinkedList;

public class DFS_11559 {
    static char[][] map = new char[12][6];
    static boolean[][] visited;
    static int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};
    static ArrayList<Point> puyoPoints;
    static int ans=0;

    public static boolean isValid(int dy, int dx){
        return (dy < 12 && dy >= 0) && (dx < 6 && dx >=0 ) ? true : false;
    }

    public static void deletePuyo(){
        for(Point temp : puyoPoints){
            map[temp.y][temp.x] = '.';
        }
    }

    public static void getNewMap(){
        for(int j=0; j<6; j++){
            Deque<Character> dq = new LinkedList<>();
            for(int i=11; i>=0; i--){
                dq.add(map[i][j]);
            }
            for(int i=0; i<12; i++){
                char temp = dq.pollFirst();
                if(temp == '.')
                    continue;
                else
                    dq.addLast(temp);
            }
            while(dq.size() < 12){
                dq.addLast('.');
            }
            for(int i=11; i>=0; i--){
                map[i][j] = dq.pollFirst();
            }
        }
    }
    public static void dfs(int dy, int dx, int target){
        for(int i=0; i<4; i++){
            int ny = dy + dir[i][0];
            int nx = dx + dir[i][1];
            if(isValid(ny,nx) && map[ny][nx] == target && !visited[ny][nx]){
                visited[ny][nx] = true;
                puyoPoints.add(new Point(nx,ny));
                dfs(ny,nx,target);
            }
        }
    }

    public static void solution(){
        boolean isCrashed;
        while(true){
            puyoPoints = new ArrayList<>();
            visited = new boolean[12][6];
            isCrashed = false;
            for(int i=0; i<12; i++){
                for(int j=0; j<6; j++){
                    if(map[i][j] != '.'  && !visited[i][j]){
                        visited[i][j] = true;
                        puyoPoints.add(new Point(j,i));
                        dfs(i,j,map[i][j]);
                        if(puyoPoints.size() >= 4){
                            isCrashed = true;
                            deletePuyo();
                        }
                        puyoPoints.clear();
                    }
                }
            }
            if(isCrashed) {
                getNewMap();
                ans++;
            }
            else
                break;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String temp;
        for(int i=0; i<12; i++){
            temp = br.readLine();
            for(int j=0; j<6; j++){
                map[i][j] = temp.charAt(j);
            }
        }
        solution();
        bw.write(ans+"");
        bw.flush();
        bw.close();

    }
    public static void print(char[][] pmap){
        for(int i=0; i<12; i++){
            for(int j=0; j<6; j++){
                System.out.print(pmap[i][j]);
            }
            System.out.println();
        }
    }
}
