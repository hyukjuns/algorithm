package boj.dfs;

import java.io.*;
import java.util.StringTokenizer;

public class DFS_1389 {
    public static int n,m;
    public static int[][] graph;
    public static boolean[] visited;
    public static int[] result;
    public static void dfs(int v,int cnt){
        visited[v] = true;
        if(result[v] != 0) { // 0 이 아니면 목적지까지 거쳐간 횟수중 최소값 입력
            if(result[v] > cnt)
                result[v] = cnt;
        }
        else // 0이면 초기값이므로 목적지까지 거쳐간 횟수 입력
            result[v] = cnt;
        for(int i=1; i<=n; i++){
            if(visited[i]==false && graph[v][i] == 1){
                dfs(i,cnt+1);
                visited[i] = false;//백트래킹
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n+1][n+1];
        visited = new boolean[n+1];
        result = new int[n+1];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = 1;
        }

        int sum = 0;
        int min=Integer.MAX_VALUE;
        int res=0;
        for(int i=1; i<=n; i++){
            sum=0;
            dfs(i,0);
            visited[i] = false;
            for(int k=1; k<=n; k++){
                if(i==k) {
                    result[k] = 0; //result 배열 초기화
                    continue;
                }
                sum += result[k]; //케빈 베이컨수 계산
                result[k] = 0; //result 배열 초기화
            }
            if(min > sum) {
                min = sum;
                res = i;
            }
        }
        bw.write(res+"");
        bw.flush();
        bw.close();
    }
}
