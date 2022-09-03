package boj.Math;

import java.io.*;

public class Math_1904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i<=n; i++){
            dp[i] = (dp[i-2] + dp[i-1]) % 15746;
        }
        bw.write(dp[n]+"");
        bw.flush();
        bw.close();
    }
}
