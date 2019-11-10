package boj.dynamic_programming;

import java.io.*;
import java.util.StringTokenizer;

public class Dynamic_1149 {
    public static void main(String[] args)throws IOException {
        BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n+1][3];
        int[][] minArr = new int[n+1][3];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        minArr[0][0] = minArr[0][1] = minArr[0][2] = arr[0][0] = arr[0][1] = arr[0][2] = 0;
        for(int i=1; i<=n; i++){
            minArr[i][0] = Math.min(minArr[i-1][1], minArr[i-1][2]) + arr[i][0];
            minArr[i][1] = Math.min(minArr[i-1][0], minArr[i-1][2]) + arr[i][1];
            minArr[i][2] = Math.min(minArr[i-1][0], minArr[i-1][1]) + arr[i][2];
        }
        int temp = Math.min(minArr[n][0],minArr[n][1]);
        int result = Math.min(temp,minArr[n][2]);
        bw.write(result+"");
        bw.flush();
        bw.close();
    }
}
