package samsungsw;

import java.io.*;
import java.util.StringTokenizer;

public class Sw_14889 {
    static int n;
    static int[][] map;
    static boolean[] visited;
    static int ans = Integer.MAX_VALUE;
    public static void solve(int v, int len){
      if(len == n/2)
          teamAnalyze();
      else{
          for(int i=v+1; i<=n; i++){
              if(!visited[i]){
                  visited[i] = true;
                  solve(i,len+1);
              }
          }
      }
      visited[v] = false; //백트래킹
    }
    public static void teamAnalyze(){
        int idx_a=0;
        int idx_b=0;
        int[] a = new int[n/2];
        int[] b = new int[n/2];
        for(int i=1; i<=n; i++){
            if(visited[i])
                a[idx_a++] = i;
            else
                b[idx_b++] = i;
        }
        int a_squad = getPower(a);
        int b_squad = getPower(b);
        ans = Math.min(ans,Math.abs(a_squad - b_squad));
    }
    public static int getPower(int[] arr){
        int power=0;
        for(int i=0; i<n/2; i++){
            for(int j=i+1; j<n/2; j++){
                power += map[arr[i]][arr[j]] + map[arr[j]][arr[i]];
            }
        }
        return power;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        n = Integer.parseInt(br.readLine());
        map = new int[n+1][n+1];
        visited = new boolean[n+1];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solve(0,0);
        bw.write(ans+"");
        bw.flush();
        bw.close();

    }
}
