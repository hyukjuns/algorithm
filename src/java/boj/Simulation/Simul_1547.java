package boj.Simulation;

import java.io.*;
import java.util.StringTokenizer;

public class Simul_1547 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        boolean[] cups = new boolean[4];
        cups[1] = true;

        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            st = new StringTokenizer(br.readLine());
            int cupA = Integer.parseInt(st.nextToken());
            int cupB = Integer.parseInt(st.nextToken());
            boolean temp;
            temp = cups[cupA];
            cups[cupA] = cups[cupB];
            cups[cupB] = temp;
        }
        int idx=0;
        for(boolean b : cups){
            if(!b)
                idx++;
            else {
                bw.write(idx + "");
                break;
            }
        }
        bw.flush();
        bw.close();
    }
}
