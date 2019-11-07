package boj.dynamic_programming;//1003 피보나치 함수 다이나믹프로그래밍

import java.io.*;

public class Dynamic_1003 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        int[][] fibo = new int[41][41];
        fibo[0][0] = 1;
        fibo[0][1] = 0;
        fibo[1][0] = 0;
        fibo[1][1] = 1;

        for(int t=0; t<tc; t++){
            int n = Integer.parseInt(br.readLine());
            for(int i=2; i<=n; i++){
                fibo[i][0] = fibo[i-1][0] + fibo[i-2][0];
                fibo[i][1] = fibo[i-1][1] + fibo[i-2][1];
            }
            bw.write(fibo[n][0]+" "+fibo[n][1]+"\n");
        }
        bw.flush();
        bw.close();
    }
}
