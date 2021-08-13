package boj.Simulation; //2455 지능형기차 시뮬레이션
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Simulation_2455 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        int sum=0;
        int max = 0;
        int[][] station = new int[4][2];
        for(int i=0; i<4; i++){
            st = new StringTokenizer(br.readLine());
            station[i][0] = Integer.parseInt(st.nextToken());
            station[i][1] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<4; i++){
            sum -= station[i][0];
            sum += station[i][1];
            if(max < sum)
                max = sum;
        }
        bw.write(max+"");
        bw.flush();
        bw.close();
    }
}
