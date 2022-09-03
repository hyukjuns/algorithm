package boj.bruteforce;

import java.io.*;
import java.util.StringTokenizer;

public class bruteforce_14501 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] t = new int[n+1];
        int[] p = new int[n+1];
        int[] dp = new int[n+1];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<n; i++){
            dp[i+1] = Math.max(dp[i],dp[i+1]);
            if(i+t[i] <= n)
                dp[i+t[i]] = Math.max(dp[i+t[i]], dp[i] + p[i]);
        }
        bw.write(dp[n]+"");
        bw.flush();
        bw.close();

    }
}
