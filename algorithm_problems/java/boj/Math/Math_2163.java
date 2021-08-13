package boj.Math;

import java.io.*;
import java.util.StringTokenizer;

public class Math_2163 {
    public static void main(String[] args) throws IOException{
        BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] dp = new int[n*m+1];
        for(int i=1; i<=n*m; i++){
            dp[i] = i-1;
        }
        bw.write(dp[n*m]+"");
        bw.flush();
        bw.close();
    }
}
