package boj.Math;

import java.io.*;
import java.util.StringTokenizer;
public class Math_1476 {
        public static void main(String args[]) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int e = Integer.parseInt(st.nextToken()); //15
            int s = Integer.parseInt(st.nextToken()); //28
            int m = Integer.parseInt(st.nextToken());//19
            int year=1;
            //year - e = 15 * x <- year 에서 e를 빼면 15의 x배수가 됨
            //year - s = 28 * y
            //year - m = 19 * z
            //주어진 각 수를 나머지라 생각하고
            //year에서 빼준뒤 각 배수로 나눠주고 나머지가 모두 0이면 그때 year가 답이된다.
            while(!((year - e) % 15 == 0 && (year - s) % 28 == 0 && (year - m) % 19 == 0)) {
                year++;
            }
            bw.write(year+"");
            bw.flush();
            bw.close();
        }
}
