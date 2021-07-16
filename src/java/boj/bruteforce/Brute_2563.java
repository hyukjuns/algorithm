package boj.bruteforce;

import java.awt.*;
import java.io.*;
import java.util.StringTokenizer;

public class Brute_2563 {
    public static void  main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[100][100];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            Point temp = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            for(int j=temp.x; j<temp.x+10; j++){
                for(int k=temp.y; k<temp.y+10; k++){
                    map[j][k] = 1;
                }
            }
        }
        int cnt=0;
        for(int i=0; i<100; i++){
            for(int j=0; j<100; j++){
                if(map[i][j]==1)    cnt++;
            }
        }
        bw.write(cnt+"");
        bw.flush();
        bw.close();
    }
}
