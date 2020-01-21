package samsungsw;
import java.io.*;
import java.util.*;

class Sw_14500{
    static int n,m;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    static int ans = Integer.MIN_VALUE;

    public static boolean isValid(int dy, int dx) {
        return (dy>=0 && dy<n) && (dx>=0 && dx<m) ? true : false;
    }

    public static void dfs(int dy, int dx, int cnt, int sum) {
        visited[dy][dx] = true;
        if(cnt == 4) {
            ans = Math.max(ans, sum);
            return;
        }
        for(int i=0; i<4; i++) {
            int ny = dy + dir[i][0];
            int nx = dx + dir[i][1];
            if(isValid(ny,nx) && !visited[ny][nx]) {
                dfs(ny,nx,cnt+1,map[ny][nx] + sum);
                visited[ny][nx] = false;
            }
        }
    }
    public static void middle(int dy, int dx, int sum) {
        if(isValid(dy-1,dx) && isValid(dy+1,dx) && isValid(dy,dx+1)) // ㅏ
            ans = Math.max(ans, sum + map[dy-1][dx] + map[dy+1][dx] + map[dy][dx+1]);
        if(isValid(dy-1,dx) && isValid(dy+1,dx) && isValid(dy,dx-1)) // ㅓ
            ans = Math.max(ans, sum + map[dy-1][dx] + map[dy+1][dx] + map[dy][dx-1]);
        if(isValid(dy-1,dx) && isValid(dy,dx-1) && isValid(dy,dx+1)) // ㅗ
            ans = Math.max(ans, sum + map[dy-1][dx] + map[dy][dx-1] + map[dy][dx+1]);
        if(isValid(dy+1,dx) && isValid(dy,dx-1) && isValid(dy,dx+1)) // ㅜ
            ans = Math.max(ans, sum + map[dy+1][dx] + map[dy][dx-1] + map[dy][dx+1]);
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                dfs(i,j,1,map[i][j]);
                middle(i,j,map[i][j]);
                visited[i][j] = false;
            }
        }
        bw.write(ans+"");
        bw.flush();
        bw.close();
    }
}