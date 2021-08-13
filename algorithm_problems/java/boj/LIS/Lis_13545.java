package boj.LIS;

import java.io.*;
import java.util.StringTokenizer;

public class Lis_13545 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());
        String arr = "0"+br.readLine();
        int query = Integer.parseInt(br.readLine());
        while(query-- > 0){
            int ans=0;
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            StringBuilder sb = new StringBuilder(arr);
            int[] dp = new int[end-start+2];
            for(int i=start; i<end; i++){
                if((sb.charAt(i)-'0' + sb.charAt(i+1)-'0') == 0){
                    dp[i] = dp[i-1] + 1;
                    sb.delete(i,i+1);
                    if(ans < dp[i])
                        ans = dp[i];
                }
            }
            System.out.println(ans);
        }

    }
}
