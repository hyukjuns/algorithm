package programmers.kakao_blind_2021;

import java.io.BufferedWriter;
import java.io.IOException;

public class sol_4 {
    static int[][] arr;
    public static void main(String[] args) throws IOException{
        int n = 6;
        int s = 4;
        int a = 6;
        int b = 2;
        int[][] fares = new int[][] {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
        System.out.println(solution(n,s,a,b,fares));
    }
    public static int solution(int n, int s, int a, int b, int[][] fares) {
        arr = new int[n][n];
        for(int i=0; i<fares.length; i++){
            int c = fares[i][0];
            int d = fares[i][1];
            int f = fares[i][2];
            arr[c][d] = arr[d][c] = f;
        }
        int min = Integer.MAX_VALUE;
        min = Math.min(min,floydWarshall(s,a,b,n));
        int answer = min;
        return answer;
    }
    static int floydWarshall(int s, int a, int b, int number){
        int[][] dp = new int[number][number];
        for(int i=0; i<number; i++){
            for(int j=0; j<number; j++){
                dp[i][j] = arr[i][j];
            }
        }

        //k = 거쳐가는 노드
        for(int k=0; k<number; k++){
            // i = 출발 노드
            for(int i=0; i<number; i++){
                //j = 도착 노드
                for(int j=0; j<number; j++){
                    if(dp[i][k]+dp[k][j] < dp[i][j]){
                        dp[i][j] = dp[i][k]+dp[k][j];
                    }
                }
            }
        }

        return 1;
    }
}
