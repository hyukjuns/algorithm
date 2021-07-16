package boj.Simulation;

import java.io.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.StringTokenizer;

public class Simul_2460 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] people = new int[10][2];
        for(int i=0; i<10; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            people[i][0] = Integer.parseInt(st.nextToken());
            people[i][1] = Integer.parseInt(st.nextToken());
        }

        int sum=0;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<10; i++){
            sum += people[i][1] - people[i][0];
            max = Integer.max(max,sum);
        }
        bw.write(max+"");
        bw.flush();
        bw.close();

    }
}
