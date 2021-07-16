package boj.dynamic_programming;

import java.io.*;

public class Dynamic_2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n =Integer.parseInt(br.readLine());
        int[] grape = new int[10001];
        int[] dp = new int[10001];
        for(int i=1; i<=n; i++){
            grape[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 0;
        dp[1] = grape[1];
        dp[2] = grape[1] + grape[2];
        for(int i=3; i<=n; i++){
            dp[i] = Math.max(dp[i-2] + grape[i], dp[i-3] + grape[i-1] + grape[i]);//1
            dp[i] = Math.max(dp[i-1],dp[i]);//2
        }
        /* 1. n-1 잔을 마시지 않았을 경우와  n-1 잔을 마셨을 경우 중 큰값 선텍
               (n-1잔을 마시지 않았을 경우 : n-2잔 선택가능
                n-1 잔을 마셨을 경우 : n-2잔 선택 불가능하므로 n-3잔 선택)
        *  2. 현재 위치의 잔을 마시지 않았을경우 와 마셨을 경우 중 큰값 선택*/
        if(n==1)
            bw.write(dp[1]+"");
        else if(n==2)
            bw.write(dp[2]+"");
        else
            bw.write(dp[n]+"");
        bw.flush();
        bw.close();
    }
}
