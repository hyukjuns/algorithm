package boj.dynamic_programming;

import java.io.*;
import java.util.StringTokenizer;

public class Dynamic_11052 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());
        int[] p = new int[n+1];
        int[] dp = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            p[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                dp[i] = Math.max(dp[i], p[j] + dp[i-j]);//이전값과 계속 비교하여 최대값을 넣어줌
            }
        }

        bw.write(dp[n]+"");
        bw.flush();
        bw.close();
    }
}
