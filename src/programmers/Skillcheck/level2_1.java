package programmers.Skillcheck;

import java.io.*;

public class level2_1 {
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] land = new int[][] {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
        bw.write(solution(land)+"");
        bw.flush();
        bw.close();
    }
    public static int solution(int[][] land) {
        int[][] temp = new int[100001][4];
        for(int i=0; i<4; i++){
            temp[0][i] = land[0][i];
        }
        for(int i=1; i<land.length; i++){
            for(int j=0; j<4; j++){
                for(int k=0; k<4; k++){
                    if(j==k)    continue;
                    temp[i][j] = Math.max(temp[i][j], land[i][j]+temp[i-1][k]);
                }
            }
        }
        int ans=0;
        for(int i=0; i<4; i++){
            ans = Math.max(ans, temp[land.length-1][i]);
        }
        return ans;
    }
}
