package boj.dynamic_programming;

import java.io.*;
import java.util.StringTokenizer;

public class Dynamic_1912 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] num = new int[1000001];
        int[] dp = new int[1000001];
        for(int i=1; i<=n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        int sum=num[1];
        dp[1] = num[1];
        for(int i=2; i<=n; i++){
            dp[i] = Math.max(dp[i-1]+num[i],num[i]);
            if(sum<dp[i])
                sum = dp[i];
        }

        bw.write(sum+"");
        bw.flush();
        bw.close();
    }
}

