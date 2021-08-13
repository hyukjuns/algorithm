package boj.etc;

import java.io.*;
import java.util.StringTokenizer;

public class Etc_9501 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());
        while(testCase-- > 0){
            int ans=0;
            st = new StringTokenizer(br.readLine());
           int n = Integer.parseInt(st.nextToken());
           int d = Integer.parseInt(st.nextToken());
           for(int i=0; i<n; i++){
               st = new StringTokenizer(br.readLine());
               double v = Double.parseDouble(st.nextToken());
               double f = Double.parseDouble(st.nextToken());
               double c = Double.parseDouble(st.nextToken());
               double total = (f/c)*v;
               if(total >= d){
                   ans++;
               }
           }
           bw.write(ans+"\n");
        }
        bw.flush();
        bw.close();
    }
}
