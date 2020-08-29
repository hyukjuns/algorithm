package boj.bruteforce;

import java.io.*;
import java.util.StringTokenizer;

public class Brute_10819 {
    static int n;
    static int[] arr,target;
    static boolean[] used;
    static int ans = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        target = new int[n];
        used = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0);
        bw.write(ans+"");
        bw.flush();
        bw.close();
    }
    public static void dfs(int index){
        if(index == n){
            int sum=0;
            for(int i=0; i<n-1; i++){
                sum += Math.abs(target[i]-target[i+1]);
            }
            ans = Math.max(ans,sum);
            return;
        }
        for(int i=0; i<n; i++){
            if(!used[i]){
                used[i]=true;
                target[index] = arr[i];
                dfs(index+1);
                used[i]=false;
            }
        }
    }

}
