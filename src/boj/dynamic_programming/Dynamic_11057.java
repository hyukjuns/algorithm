package boj.dynamic_programming;

import java.io.*;

public class Dynamic_11057 {
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        int[][] dp = new int[1001][10];
        for(int i=0; i<10; i++){
            dp[1][i] = 1;
        }
        for(int i=2; i<=n; i++){
            for(int j=0; j<10; j++){
                for(int k=j; k<10; k++){
                    dp[i][j] += (dp[i-1][k] % 10007);
                }
            }
        }

        int sum=0;
        for(int i=0; i<10; i++){
            sum += (dp[n][i] % 10007);
        }
        bw.write(sum%10007+"");
        bw.flush();
        bw.close();

    }
}
