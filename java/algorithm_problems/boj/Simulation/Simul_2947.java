package boj.Simulation;

import java.io.*;
import java.util.StringTokenizer;

public class Simul_2947 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[6];
        for(int i=1; i<=5; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        while(true){
            if(arr[1] > arr[2]){
                int temp = arr[2];
                arr[2] = arr[1];
                arr[1] = temp;
                for(int i=1; i<=5; i++){
                    bw.write(arr[i]+" ");
                }
                bw.write("\n");
            }
            if(arr[2] > arr[3]){
                int temp = arr[3];
                arr[3] = arr[2];
                arr[2] = temp;
                for(int i=1; i<=5; i++){
                    bw.write(arr[i]+" ");
                }
                bw.write("\n");
            }
            if(arr[3] > arr[4]){
                int temp = arr[4];
                arr[4] = arr[3];
                arr[3] = temp;
                for(int i=1; i<=5; i++){
                    bw.write(arr[i]+" ");
                }
                bw.write("\n");
            }
            if(arr[4] > arr[5]){
                int temp = arr[5];
                arr[5] = arr[4];
                arr[4] = temp;
                for(int i=1; i<=5; i++){
                    bw.write(arr[i]+" ");
                }
                bw.write("\n");
            }
            boolean isEnd=true;
            for(int i=1; i<=5; i++){
                if(arr[i] != i){
                    isEnd = false;
                    break;
                }
            }
            if(isEnd)   break;
        }
        bw.flush();
        bw.close();

    }

}
