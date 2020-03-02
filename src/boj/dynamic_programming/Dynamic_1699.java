package boj.dynamic_programming;

import java.io.*;

public class Dynamic_1699 {
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[100001];
        dp[1]=1;
        dp[2]=2;
        for(int i=3; i<=n; i++){
            if(Math.sqrt(i)-(int)Math.sqrt(i) == (double)0)
                dp[i]=1;
            else{
                int idx=i-1;
                int sum=Integer.MAX_VALUE;
                while(idx >= i/2){
                    sum = Math.min(sum,dp[idx] + dp[i-idx]);
                    idx--;
                }
                dp[i] = sum;
            }
        }
        bw.write(dp[n]+"");
        bw.flush();
        bw.close();
    }
}
