package boj.LCS;

import java.io.*;

public class Lcs_5582 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str1 = br.readLine();
        String str2 = br.readLine();
        int ans=0;
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        for(int i=1; i<=str1.length(); i++){
            for(int j=1; j<=str2.length(); j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    if(ans < dp[i][j]){
                        ans = dp[i][j];
                    }
                }
            }
        }
        bw.write(ans+"");
        bw.flush();
        bw.close();
    }
}
