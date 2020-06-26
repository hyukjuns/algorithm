package boj.Math;

import java.io.*;
import java.util.StringTokenizer;

public class Math_1074 {
    public static void solve(int[][] arr, int size, int r, int c){
        if(size != 2){
            solve(arr,size/2,r,c);
        }
        for(int i=0; i<size; i++){
            
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int size = (int)Math.pow(2,n);
        int[][] arr = new int[size][size];
        solve(arr,size,r,c);

    }
}
