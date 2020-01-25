package boj.Math;

import java.io.*;

public class Math_2010 {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        if(n==1) {
            bw.write(br.readLine());
            bw.flush();
            bw.close();
            return;
        }
        int sum=0;
        for(int i=0; i<n-1; i++){
            int hole = Integer.parseInt(br.readLine());
            sum += hole-1;
        }
        sum += Integer.parseInt(br.readLine());
        bw.write(sum+"");
        bw.flush();
        bw.close();
    }
}
