package boj.search;

import java.io.*;
import java.util.StringTokenizer;

public class Search_1024 {
    static int n,l;
    static String ans="";
    static boolean unable=false;

    static void solution(){
       for(int i=l; i<=100; i++){
           int t = (i-1)*i/2;
           int x = (n-t)/i;
           int nmg  = (n-t)%i;
           if(x<0)  continue;
           if(nmg==0){
               int cnt=0;
               while(cnt < i){
                   ans += x + " ";
                   x++;
                   cnt++;
               }
               return;
           }
       }
       unable = true;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        solution();
        if(unable)
            bw.write("-1");
        else
            bw.write(ans);
        bw.flush();
        bw.close();
    }
}
