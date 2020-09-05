package boj.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS_1260 {
    static int n,m,v;
    static int[][] arr;
    static boolean[] visited;
    static Queue<Integer> ansQue = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        arr = new int[n+1][n+1];
        visited = new boolean[n+1];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a] = 1;
        }
        dfs(v);
        while(!ansQue.isEmpty()){
            bw.write(ansQue.poll()+" ");
        }
        bw.write("\n");
        visited = new boolean[n+1];
        bfs(v);
        while(!ansQue.isEmpty()){
            bw.write(ansQue.poll()+" ");
        }
        bw.flush();
        bw.close();

    }
    public static void dfs(int v){
        visited[v] = true;
        ansQue.add(v);
        for(int i=1; i<=n; i++){
            if(arr[v][i] != 0 && !visited[i]){
                dfs(i);
            }
        }
    }
    public static void bfs(int v){
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visited[v]= true;
        while(!q.isEmpty()){
            int temp = q.poll();
            ansQue.add(temp);
            for(int i=1; i<=n; i++){
                if(arr[temp][i] != 0 && !visited[i]){
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}
