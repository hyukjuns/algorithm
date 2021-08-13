package boj.etc;

import java.io.*;
import java.util.StringTokenizer;

public class etc_2884 {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int minute = h*60 + m;
        if(minute < 45)
            minute = (24 * 60 + m) - 45;
        else
            minute -= 45;
        bw.write(minute/60+" "+minute%60);
        bw.flush();
        bw.close();
    }
}
