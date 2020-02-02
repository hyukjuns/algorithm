package boj.bfs;

import java.io.*;
import java.util.*;

public class BFS_2589 {
    static int n,m;
    static char[][] map;
    static boolean[][] visited;
    static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    static int ans=0;
    public static boolean isValid(int dy, int dx){
        return (dy>=0 && dy<n) && (dx>=0 && dx<m) ? true : false;
    }
    public static void bfs(int dy, int dx){
        Queue<Info> q = new LinkedList<>();
        q.offer(new Info(dy,dx,0));
        Info cur = null;
        visited[dy][dx] = true;
        while(!q.isEmpty()){
            cur = q.poll();
            for(int i=0; i<4; i++){
                int ny = cur.y + dir[i][0];
                int nx = cur.x + dir[i][1];
                if(isValid(ny,nx) && map[ny][nx] == 'L' && !visited[ny][nx]){
                    q.offer(new Info(ny,nx,cur.cnt+1));
                    visited[ny][nx] = true;
                }
            }
        }
        ans = ans < cur.cnt ? cur.cnt : ans;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];

        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<m; j++){
                map[i][j] = str.charAt(j);
            }
        }

        for(int i=0; i<n; i++){;
            for(int j=0; j<m; j++){
                if(map[i][j] == 'L') {
                    visited = new boolean[n][m];
                    bfs(i, j);
                }
            }
        }

        bw.write(ans+"");
        bw.flush();
        bw.close();
    }
}
class Info{
    int y;
    int x;
    int cnt;
    public Info(int y, int x, int cnt){
        this.y = y;
        this.x = x;
        this.cnt = cnt;
    }
}

