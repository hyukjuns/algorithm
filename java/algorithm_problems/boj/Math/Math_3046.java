package boj.Math;

import java.io.*;
import java.util.StringTokenizer;

public class Math_3046 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int r2;
        int s = Integer.parseInt(st.nextToken());
        r2 = s*2 - r1;
        bw.write(r2+"");
        bw.flush();
        bw.close();
    }
}
