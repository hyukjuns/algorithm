package boj.dynamic_programming;

import java.io.*;

public class Dynamic_11726 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] rect = new int[1001];
        rect[1] = 1;
        rect[2] = 2;
        for(int i=3; i<=n; i++){
            rect[i] = (rect[i-1]+rect[i-2]) % 10007;
        }
        bw.write(rect[n]+"");
        bw.flush();
        bw.close();
    }
}
