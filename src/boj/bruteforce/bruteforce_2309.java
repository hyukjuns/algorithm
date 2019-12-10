package boj.bruteforce;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class bruteforce_2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] height = new int[9];
        for(int i=0; i<9; i++){
            height[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(height);
        int sum=0;
        int[] result = new int[7];
        int idx=0;
        for(int i=0; i<9; i++){
           for(int j=i+1; j<9; j++){
               idx=0;
               sum=0;
               for(int k=0; k<9; k++){
                   if(k==i || k==j)
                       continue;
                   sum += height[k];
                   result[idx++] = k;
               }
               if(sum==100)
                   break;
           }
           if(sum==100)
               break;
        }

        for(int i=0; i<7; i++){
            bw.write(height[result[i]]+"\n");
        }
        bw.flush();
        bw.close();
    }
}
