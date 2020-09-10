package boj.greedy;

import java.io.*;

public class Greedy_10162 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int[] button = new int[] {300,60,10};//0,1,2 == a,b,c
        int[] mok = new int[3];

        for(int i=0; i<3; i++){
            mok[i] = T/button[i];
            T = T%button[i];
        }
        if(T != 0){
            bw.write("-1");
        }else {
            for (int i = 0; i < 3; i++) {
                bw.write(mok[i] + " ");
            }
        }
        bw.flush();
        bw.close();
    }
}
