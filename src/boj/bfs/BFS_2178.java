package boj.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS_2178 {
    static int n,m;
    static int[][] graph;
    static boolean[][] visited;
    static int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};
    static int ans=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[101][101];
        visited = new boolean[101][101];
        for(int i=1; i<=n; i++){
            String temp = br.readLine();
            for(int j=1; j<=m; j++){
                graph[i][j] = temp.charAt(j-1) - '0';
            }
        }
        bfs(1,1,1);
        bw.write(ans+"");
        bw.flush();
        bw.close();
    }
    public static void bfs(int y, int x,int cnt){
        Queue<Info2> q  = new LinkedList<>();
        q.add(new Info2(y,x,cnt));
        visited[y][x] = true;
        while(!q.isEmpty()){
            Info2 temp = q.poll();
            if(temp.y == n && temp.x == m) {
                ans = temp.cnt;
                break;
            }
            int dy,dx;
            for(int i=0; i<4; i++){
                dy = temp.y + dir[i][0];
                dx = temp.x + dir[i][1];
                if(isValid(dy,dx) && graph[dy][dx] == 1 && !visited[dy][dx]){
                    visited[dy][dx] = true;
                    q.add(new Info2(dy,dx,temp.cnt +1));
                }
            }
        }
    }
    public static boolean isValid(int dy, int dx){
        return ((dy>0 && dy<=n) && (dx >0 && dx <=m)) ? true : false;
    }
}
class Info2{
    int y;
    int x;
    int cnt;
    public Info2(int y, int x, int cnt){
        this.y = y;
        this.x = x;
        this.cnt = cnt;
    }
}
