package boj.bruteforce;

import java.io.*;

public class Brute_1748 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int ans=0;
        for(int i=1; i<=n; i*=10){
            ans += n - (i-1);
        }
        System.out.println(ans);

    }
}
