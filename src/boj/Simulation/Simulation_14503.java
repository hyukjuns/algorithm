package boj.Simulation;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Simulation_14503 {
    private static int n,m;
    private static int r,c,d;
    private static int[][] graph;
    private static boolean[][] cleaned;
    private static int[][] dir= {{-1,0},{0,1},{1,0},{0,-1}}; //N E S W
    public static boolean isValid(int dy, int dx){
        return (dy>=0 && dy<n) && (dx>=0 && dx<m);
    }
    public static int solution(){
        int res=0;
        Queue<DOT> q = new LinkedList<>();

        q.add(new DOT(r,c,d)); //현 시작위치 청소
        cleaned[r][c] = true;
        res++;

        while(!q.isEmpty()){
            DOT temp = q.poll();
            boolean check = false;
            for(int i=0; i<4; i++){
                int nextDir = (temp.direct + (3-i)) % 4;
                int nextY = temp.y + dir[nextDir][0];
                int nextX = temp.x + dir[nextDir][1];
                if(isValid(nextY,nextX) && !cleaned[nextY][nextX] && graph[nextY][nextX] != 1){
                    q.add(new DOT(nextY,nextX,nextDir));
                    cleaned[nextY][nextX] = true;
                    res++;
                    check = true;
                    break;
                }
            }
            if(!check) {// 네 방향 모두 막힘
                int backY = temp.y - dir[temp.direct][0];
                int backX = temp.x - dir[temp.direct][1];
                if(isValid(backY,backX) && graph[backY][backX] != 1) {
                    q.add(new DOT(backY,backX,temp.direct));
                }
                else
                    break;
            }
        }
        return res;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        cleaned = new boolean[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result = solution();
        bw.write(result+"");
        bw.flush();
        bw.close();
    }
}
class DOT{
    int y;
    int x;
    int direct;
    public DOT(int y, int x, int direct){
        this.y = y;
        this.x = x;
        this.direct = direct;
    }
}


