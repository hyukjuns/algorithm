package boj.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class Greedy_1120 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();
        int iter = b.length() - a.length();
        int min = 50;

        for(int i=0; i<=iter; i++){
            int cnt=0;
            for(int j=0; j<a.length(); j++){
                if(a.charAt(j) != b.charAt(j+i))
                    cnt++;
            }
            min = Math.min(cnt,min);
        }
        bw.write(min+"");
        bw.flush();
        bw.close();

    }
}
