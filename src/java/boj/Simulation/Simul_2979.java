package boj.Simulation;

import java.io.*;
import java.util.StringTokenizer;

public class Simul_2979 {
    static int a,b,c;
    static int[][] times = new int[101][1];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum=0;
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        for(int i=0; i<3; i++){
            st = new StringTokenizer(br.readLine());
            int arrive = Integer.parseInt(st.nextToken());
            int depature = Integer.parseInt(st.nextToken());
            for(int j=arrive; j<depature; j++){
                times[j][0] += 1;
            }
        }
        for(int i=1; i<101; i++){
            if(times[i][0]==0)  continue;
            else if(times[i][0]==1)
                sum += a;
            else if(times[i][0]==2)
                sum += 2*b;
            else if(times[i][0]==3)
                sum += 3*c;
        }
        bw.write(sum+"");
        bw.flush();
        bw.close();

    }
}
