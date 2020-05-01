package boj.Floyd_Warshall;

import java.io.*;
import java.util.StringTokenizer;

public class floyd_11404 {
    static int n,m;
    static int[][] arr;
    static int INF=10000000;

    static void floydWarshall(){
        int[][] dp = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                dp[i][j] = arr[i][j];
            }
        }

        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(dp[i][k]+dp[k][j] < dp[i][j]){
                        dp[i][j] = dp[i][k]+dp[k][j];
                    }
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(dp[i][j] >= INF){
                    System.out.print("0 ");
                }
                else
                    System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken());
            if(arr[a][b] != 0)
                arr[a][b] = Math.min(arr[a][b],c);
            else
                arr[a][b] = c;
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i != j && arr[i][j]==0){
                    arr[i][j] = INF;
                }
            }
        }

        floydWarshall();
    }
}
