package boj.dynamic_programming;

import java.io.*;

public class Dynamic_9461 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        long[] dp = new long[101];
        while(tc != 0){
            int n = Integer.parseInt(br.readLine());
            dp[1] = dp[2] = 1;
            for(int i=3; i<=n; i++){
                dp[i] = dp[i-2] + dp[i-3];
            }
            bw.write(dp[n]+"\n");
            tc--;
        }
        bw.flush();
        bw.close();
    }
}
