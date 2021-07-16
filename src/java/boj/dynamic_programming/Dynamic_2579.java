package boj.dynamic_programming; //2579 계단 오르기 다이나믹 프로그래밍

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import  java.io.IOException;

public class Dynamic_2579 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] step = new int[301];
        int[] sum = new int[301];

        int numOfStep = Integer.parseInt(br.readLine());
        for(int i=1; i<=numOfStep; i++){
            step[i] = Integer.parseInt(br.readLine());
        }
        sum[1] = step[1];
        sum[2] = Math.max(sum[1]+ step[2], step[2]);
        sum[3] = Math.max(step[3]+sum[1], step[3]+step[2]);
        for(int i = 4; i<=numOfStep; i++){
            sum[i] = Math.max(step[i]+step[i-1]+sum[i-3] , step[i]+sum[i-2]);
        }//전칸 밟은 경우, 전칸 안밟고 전전칸 밟은 경우 두가지 경우 중 큰값 선택
        bw.write(sum[numOfStep]+"");
        bw.flush();
        bw.close();
    }
}
