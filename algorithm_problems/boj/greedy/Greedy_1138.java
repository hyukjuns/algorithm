package boj.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class Greedy_1138 {
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] temp = new int[n];
        for(int i=0; i<n; i++){
            int left = arr[i];
            for(int j=0; j<n; j++){
                if(left == 0 && temp[j]==0){
                    temp[j] = i+1;
                    break;
                }
                else if(temp[j] == 0){
                    left--;
                }
            }
        }
        for(int i=0; i<n; i++){
            bw.write(temp[i]+" ");
        }
        bw.flush();
        bw.close();
    }
}
