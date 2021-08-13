package samsungsw;

import java.io.*;
import java.util.StringTokenizer;

public class Sw_13458 {
    static int n;
    static long[] arr;
    static long[] supervisor;
    static int b,c;

    public static long solve(){
        int idx=0;
        while(idx < n){
            long students = arr[idx];
            if(students <= b)
                supervisor[idx] = 1; //총감독 1인
            else if((students - b) % c == 0)
                supervisor[idx] = (students - b) / c + 1; // 부담독s(몫) + 총감독 1
            else
                supervisor[idx] = (students - b) / c + 2; // 부감독s(몫) + 총감독 1 + 부감독 1(나머지를 1명이 처리)
            idx++;
        }
        long sum=0;
        for(int i=0; i<n; i++){
            sum += supervisor[i];
        }
        return sum;
    }
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= null;
        n = Integer.parseInt(br.readLine());
        arr = new long[n];
        supervisor = new long[n];
        st= new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st= new StringTokenizer(br.readLine());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        long ans = solve();
        bw.write(ans+"");
        bw.flush();
        bw.close();
    }
}
