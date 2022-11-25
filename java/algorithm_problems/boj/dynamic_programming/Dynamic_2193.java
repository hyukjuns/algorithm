package boj.dynamic_programming;

import java.io.*;

public class Dynamic_2193 {
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long [] pinary = new long[91];
        pinary[1] = 1;
        pinary[2] = 1;
        for(int i=3; i<=n; i++){
            pinary[i] = pinary[i-1] + pinary[i-2];
        }
        bw.write(pinary[n]+"");
        bw.flush();
        bw.close();
    }
}
