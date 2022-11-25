package boj.dynamic_programming;

import java.io.*;
import java.util.StringTokenizer;

public class Dynamic_11053 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int[] dp = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        int max = dp[1];
        for(int i=2; i<=n; i++){
            for(int j=1; j<i; j++){
                if(arr[i] > arr[j] && dp[i] <= dp[j]){
                    dp[i] = dp[j] + 1;
                }
            }
            if(max < dp[i])
                max = dp[i];
        }
        bw.write(max+"");
        bw.flush();
        bw.close();
    }
}
