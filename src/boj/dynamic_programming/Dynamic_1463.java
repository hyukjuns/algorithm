package boj.dynamic_programming; //1463 1로 만들기 dynamic programming

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Dynamic_1463 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n =  Integer.parseInt(br.readLine());
        int[] numArr = new int[1000001];
        numArr[1] = 0;
        numArr[2] = numArr[3] = 1;
        for(int i=4; i<=n; i++){
            numArr[i] = numArr[i-1]+1;
            if(i % 3 == 0){
                numArr[i] = Math.min(numArr[i],numArr[i/3]+1);
            }
            if(i % 2 == 0){
                numArr[i] = Math.min(numArr[i],numArr[i/2]+1);
            }
        }
        bw.write(numArr[n]+"");
        bw.flush();
        bw.close();
    }
}
