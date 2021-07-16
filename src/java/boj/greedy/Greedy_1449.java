package boj.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Greedy_1449 {
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[] leak = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            leak[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(leak);
        int cnt=1;
        double cur= leak[0];
        double prev = cur - 0.5 + l;
        for(int i=1; i<n; i++){
            cur = leak[i];
            if(cur + 0.5 <= prev)
                continue;
            else if(cur-0.5 <= prev && cur+0.5 > prev){
                prev = prev+l;
                cnt++;
            }
            else if(cur-0.5 > prev){
                prev = cur - 0.5 + l;
                cnt++;
            }
        }
        bw.write(cnt+"");
        bw.flush();
        bw.close();
    }
}
