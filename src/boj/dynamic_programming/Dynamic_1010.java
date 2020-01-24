package boj.dynamic_programming;

import java.io.*;
import java.util.StringTokenizer;

public class Dynamic_1010 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        while(tc != 0){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] dp = new int[n+1][m+1];
            for(int i=1; i<=m; i++){
                dp[1][i] = i;
            }
            for(int i=2; i<=n ;i++){
                for(int j=i; j<=m; j++){
                    for(int k =j-1; k>0; k--){
                        dp[i][j] += dp[i-1][k];
                    }
                }
            }
            bw.write(dp[n][m]+"\n");
            tc--;
        }
        bw.flush();
        bw.close();
    }
}
