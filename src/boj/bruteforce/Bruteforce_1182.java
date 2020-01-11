package boj.bruteforce;

import java.io.*;
import java.util.StringTokenizer;

public class Bruteforce_1182 {
    private static int[] arr;
    private static int n,s;
    private static int cnt=0;
    public static void alu(int idx, int sum){
        if(idx>=n)
            return;
        sum += arr[idx];
        if(sum == s)
            cnt++;

        alu(idx+1, sum - arr[idx]); //해당수 사용안함;
        alu(idx+1, sum);//해당수 사용함

    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        alu(0,0);
        bw.write(cnt+"");
        bw.flush();
        bw.close();

    }
}
