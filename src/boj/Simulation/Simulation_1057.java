package boj.Simulation;

import java.io.*;
import java.util.StringTokenizer;

public class Simulation_1057 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int cnt=0;
        while(a!=b){
            a = (a+1)/2;
            b = (b+1)/2;
            cnt++;
        }
        bw.write(cnt+"");
        bw.flush();
        bw.close();

    }
}
