package boj.dynamic_programming;

import java.io.*;

public class Dynamic_11727 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 3;
        for(int i=3; i<=n; i++){
            dp[i] = (dp[i-1] + dp[i-2]*2) %10007;
        }
        bw.write(dp[n]+"");
        bw.flush();
        bw.close();
    }
}
