package boj.Simulation;

import java.io.*;
import java.util.*;

public class Simul_16234 {
    static int n,l,r;
    static int[][] map;
    static boolean[][] visited;
    static int[][] getDir = {{0,1},{1,0},{0,-1},{-1,0}};
    static Deque<Deque> unions;
    public static boolean getDiff(int dy, int dx, int ny, int nx){
        int diff = Math.abs(map[dy][dx] - map[ny][nx]);
        if(diff >= l && diff <= r)
            return true;
        else
            return false;
    }
    public static void solve(int dy, int dx){
        Deque<Nation> nations = new LinkedList<>();
        Deque<Nation> tempNations = new LinkedList<>();
        nations.add(new Nation(dy,dx,map[dy][dx]));
        visited[dy][dx] = true;
        int ny, nx;
        while(!nations.isEmpty()){
            Nation temp = nations.poll();;
            tempNations.add(temp);
            for(int i=0; i<4; i++){
                ny = temp.r + getDir[i][0];
                nx = temp.c + getDir[i][1];
                if((ny>=0 && ny<n) && (nx>=0 && nx<n)){
                    if(!visited[ny][nx] && getDiff(temp.r,temp.c,ny,nx)){
                        //국경선을 공유하는 두 나라의 인구 차이가 L명 이상, R명 이하라면,
                        // 두 나라가 공유하는 국경선을 오늘 하루동안 연다.
                        visited[ny][nx] = true;
                        nations.add(new Nation(ny,nx,map[ny][nx]));
                    }
                }
            }
        }
        if(tempNations.size() > 1)
            unions.add(tempNations);
    }
    public static void move(Deque<Nation> union){
        int sum=0;
        for(Nation n : union){
            sum += n.supply;
        }
        int size = union.size();
        while(!union.isEmpty()){
            //연합을 이루고 있는 각 칸의 인구수는 (연합의 인구수) / (연합을 이루고 있는 칸의 개수)가 된다.
            // 편의상 소수점은 버린다.
            Nation cur = union.poll();
            map[cur.r][cur.c] = sum / size;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        visited = new boolean[n][n];
        unions = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int moveCnt = 0;
        while(true){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    visited[i][j] = false;
                }
            }
            //하루 진행(연합 형성)
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(!visited[i][j])
                        solve(i,j);
                }
            }
            //더 이상 아래 방법에 의해 인구 이동이 없을 때까지 지속된다.
            if(unions.isEmpty())
                break;
            else{
                while (!unions.isEmpty()){
                    //위의 조건에 의해 열어야하는 국경선이 모두 열렸다면,
                    // 인구 이동을 시작한다.
                    Deque temp = unions.poll();
                    move(temp);
                }
                //연합을 해체하고, 모든 국경선을 닫는다.
            }
            moveCnt++;
        }

        bw.write(moveCnt+"");
        bw.flush();
        bw.close();
    }
}
class Nation{
    int r;
    int c;
    int supply;
    public Nation(int r, int c, int supply){
        this.r = r;
        this.c = c;
        this.supply = supply;
    }
}
