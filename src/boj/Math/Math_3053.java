package boj.Math;

import java.io.*;
import java.text.DecimalFormat;

public class Math_3053 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        DecimalFormat form = new DecimalFormat("0.000000");
        double r = Integer.parseInt(br.readLine());
        double euclidean;
        double taxi;

        euclidean = 3.14159265358979323846 * r * r;
        taxi = 2 * r * r;
        bw.write(form.format(euclidean)+"\n");
        bw.write(form.format(taxi)+"");
        bw.flush();
        bw.close();
    }
}
