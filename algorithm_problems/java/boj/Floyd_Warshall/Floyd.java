package boj.Floyd_Warshall;

import java.io.IOException;

public class Floyd {
    static int number = 4;
    static int INF = 10000000;
    static int[][] arr = {
        {0, 5, INF, 8},
        {7, 0, 9, INF},
        {2, INF, 0, 4},
        {INF, INF, 3, 0}
    };
    static void floydWarshall(){
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
        for(int i=0; i<number; i++){
            for(int j=0; j<number; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) throws IOException{
        floydWarshall();
    }
}
