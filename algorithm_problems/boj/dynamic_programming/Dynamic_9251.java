package boj.dynamic_programming;

import java.io.*;

public class Dynamic_9251 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str1 = '0'+br.readLine();
        String str2 = '0'+br.readLine();
        int len1 = str1.length();
        int len2 = str2.length();

        int[][] lcs = new int[len2][len1];
        for(int i=0; i<len1; i++){
            lcs[0][i] = 0;
        }
        for(int i=1; i<len2; i++){
            for(int j=1; j<len1; j++){
                if(str2.charAt(i) == str1.charAt(j)){
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                }
                else{
                    lcs[i][j] = Math.max(lcs[i][j-1],lcs[i-1][j]);
                }
            }
        }

        System.out.println(lcs[len2-1][len1-1]);
        
    }
}
