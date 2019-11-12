package boj.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Greedy_1946 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int tc = Integer.parseInt(br.readLine());
        for(int i=0; i<tc; i++){
            int num = Integer.parseInt(br.readLine());
            int[][] rank = new int[num][2];
            for(int j=0; j<num; j++){
                st = new StringTokenizer(br.readLine());
                rank[j][0] = Integer.parseInt(st.nextToken());
                rank[j][1] = Integer.parseInt(st.nextToken());
            }
            int hired=0;
            Arrays.sort(rank, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[0] > o2[0])
                        return 1;
                    else
                        return -1;
                }
            });
           int meet = rank[0][1];
           hired++;
           for(int j=1; j<num; j++){
               if(meet > rank[j][1]){
                   meet = rank[j][1];
                   hired++;
               }
           }
            bw.write(hired+"\n");
        }
        bw.flush();
        bw.close();

    }
}
