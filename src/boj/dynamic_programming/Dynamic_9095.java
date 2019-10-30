package boj.dynamic_programming;//9095 1,2,3 더하기 다이나믹 프로그래밍

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Dynamic_9095 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());

        for(int i=0; i<testCase; i++) {
            int num = Integer.parseInt(br.readLine());
            int[] arr = new int[11];
            arr[1] = 1;
            arr[2] = 2;
            arr[3] = 4;
            for(int j = 4; j<=num; j++){
                arr[j] = arr[j-1] + arr[j-2] + arr[j-3];
            }
            bw.write(arr[num]+"\n");
        }
        bw.flush();
        bw.close();
    }
}
