package boj.sort;

import java.io.*;
import java.util.StringTokenizer;

public class Sort_1937 {
    static int n;
    static int[][] map;
    static int[][] dp;
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    public static int dfs(int y, int x){
        if(dp[y][x] != 1)
            return dp[y][x];
        int ny,nx;
        for(int i=0; i<4; i++){
            ny = y + dir[i][0];
            nx = x + dir[i][1];
            if(ny >= 0 && ny < n && nx >= 0 && nx < n){
                if(map[y][x] >= map[ny][nx])
                    continue;
                else if(map[y][x] < map[ny][nx])
                    dp[y][x] = Math.max(dp[y][x], dfs(ny,nx) + 1);
            }
        }
        return dp[y][x];
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = 1; //모든곳에 1일은 살수 있음
            }
        }
        int ans=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                ans = Math.max(ans,dfs(i,j));
            }
        }
        bw.write(ans+"");
        bw.flush();
        bw.close();

    }
}
