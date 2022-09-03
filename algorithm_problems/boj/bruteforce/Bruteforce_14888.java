package boj.bruteforce;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bruteforce_14888 {
    static int n;
    static int[] arr;
    static int[] alu;
    static long max = Long.MIN_VALUE;
    static long min = Long.MAX_VALUE;
    public static void solve(int plus, int minus, int multiply, int divide,long sum, int cnt){
        if(cnt==n){
            max = Math.max(max,sum);
            min = Math.min(min,sum);
        }
        if(plus>0)
            solve(plus-1,minus,multiply,divide,sum+arr[cnt],cnt+1);
        if(minus>0)
            solve(plus,minus-1,multiply,divide,sum-arr[cnt],cnt+1);
        if(multiply>0)
            solve(plus,minus,multiply-1,divide,sum*arr[cnt],cnt+1);
        if(divide>0)
            solve(plus,minus,multiply,divide-1,sum/arr[cnt],cnt+1);
    }
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        alu = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            alu[i] = Integer.parseInt(st.nextToken());
        }

        solve(alu[0],alu[1],alu[2],alu[3],arr[0],1);
        bw.write(max+"\n");
        bw.write(min+"");
        bw.flush();
        bw.close();
    }
}
