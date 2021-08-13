package boj.Math;

import java.io.*;

public class Math_1977 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int sum=0;
        int min=Integer.MAX_VALUE;
        for(int i=m; i<=n; i++){
            int target = i;
            double temp = Math.sqrt(target) - (int)Math.sqrt(target);
            if(temp == 0) {
                sum += target;
                if(min > target)
                    min = target;
            }
        }
        if(sum==0)
            bw.write("-1");
        else
            bw.write(sum+"\n"+min);
        bw.flush();
        bw.close();
    }
}
