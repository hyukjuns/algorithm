package boj.greedy;
import java.io.*;
import java.util.*;

class Greedy_2352{
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st =null;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n+1];
        dp[1] = arr[1];
        int len = 1;
        for(int i=2; i<=n; i++) {
            if(arr[i] > dp[len])
                dp[++len] = arr[i];
            else {
                int j=1;
                for(j=1; j<=len; j++) {
                    if(arr[i] <= dp[j])
                        break;
                }
                dp[j] = arr[i];
            }
        }
        bw.write(len+"");
        bw.flush();
        bw.close();
    }
}