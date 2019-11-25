package boj.dynamic_programming;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Dynamic_1932 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());
        int[][] triangle = new int[n+1][];
        int[][] sum = new int[n+1][];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            triangle[i] = new int[i+1];
            for(int j=1; j<=i; j++){
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sum[0] = new int[2];
        for(int i=1; i<=n; i++){
            sum[i] = new int[i+1];
            for(int j=1; j<=i; j++){
                if(j==1){
                    sum[i][j] = sum[i-1][j] + triangle[i][j];
                }
                else if(j==i){
                    sum[i][j] = sum[i-1][j-1] + triangle[i][j];
                }
                else{
                    sum[i][j] = Math.max(sum[i-1][j-1],sum[i-1][j]) + triangle[i][j];
                }
            }
        }
        Arrays.sort(sum[n]);
        bw.write(sum[n][sum[n].length-1]+"");
        bw.flush();
        bw.close();
    }
}
