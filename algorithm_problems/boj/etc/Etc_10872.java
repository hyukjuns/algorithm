package boj.etc;
import java.io.*;
import java.util.*;

class Etc_10872{
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st =null;
        int n = Integer.parseInt(br.readLine());
        int fact=1;
        for(int i=1; i<=n; i++) {
            fact *= i;
        }
        bw.write(fact+"");
        bw.flush();
        bw.close();
    }
}