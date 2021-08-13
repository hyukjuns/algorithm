package boj.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class Greedy_1783 {
    public static int[][] dir = {{-2,1},{-1,2},{1,2},{2,1}};
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if(n==1){
            bw.write("1");
        }
        else if(n==2){
            bw.write(Math.min(4, (m+1)/2)+"");
        }
        else{
            if(m<=6){
                bw.write(Math.min(4,m)+"");
            }
            else{
                bw.write(m-2+"");
            }
        }
        bw.flush();
        bw.close();
    }
}
