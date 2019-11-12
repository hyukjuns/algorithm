package boj.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Greedy_1049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] brand = new int[m][2];
        int[] compare = new int[m];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            brand[i][0] = Integer.parseInt(st.nextToken());
            brand[i][1] = Integer.parseInt(st.nextToken());
        }
        int res=0;
        if(n<6){
            for(int i=0; i<m; i++){
                int temp = brand[i][1] * n;
                compare[i] = Math.min(brand[i][0], temp);
            }
            Arrays.sort(compare);
            res = compare[0];
        }
        else if(n==6){
            for(int i=0; i<m; i++){
                compare[i] = Math.min(brand[i][0],n*brand[i][1]);
            }
            Arrays.sort(compare);
            res = compare[0];
        }
        else{
            int mok = n / 6;
            int nmg = n % 6;
            for(int i=0; i<m; i++){
                compare[i] = 1000 * 100;
                for(int j=0; j<m; j++) {
                    int temp = mok * brand[i][0] + nmg * brand[j][1];
                    int temp2 = (mok + 1) * brand[i][0];
                    int temp3 = n * brand[j][1];
                    int tempRes = Math.min(temp, temp2);
                    int tempRes2 =  Math.min(tempRes, temp3);
                    compare[i] = Math.min(compare[i], tempRes2);
                }
            }
            Arrays.sort(compare);
            res = compare[0];
        }
        bw.write(res+"");
        bw.flush();
        bw.close();
    }
}
