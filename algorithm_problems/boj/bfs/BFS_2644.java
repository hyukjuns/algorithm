package boj.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS_2644 {
    static int n;
    static int x,y;
    static int m;
    static int[][] graph;
    static boolean[] visited;
    static int cnt=0;
    public static void bfs(int x){
        visited[x] = true;
        Queue<Chonsu> q = new LinkedList<>();
        q.offer(new Chonsu(x,cnt));
        while(!q.isEmpty()){
            Chonsu temp = q.poll();
            if(temp.v == y) {
                cnt = temp.chonsu;
                return;
            }
            for(int i=1; i<=n; i++){
                if(graph[temp.v][i] == 1 && visited[i] == false){
                    q.offer(new Chonsu(i,temp.chonsu+1));
                    visited[i] = true;
                }
            }
        }
        cnt=-1;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        n = Integer.parseInt(br.readLine());
        graph = new int[n+1][n+1];
        visited = new boolean[n+1];
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = 1;
        }
        bfs(x);
        bw.write(cnt+"");
        bw.flush();
        bw.close();
    }
}
class Chonsu{
    int v;
    int chonsu;
    public Chonsu(int v, int chonsu){
        this.v = v;
        this.chonsu = chonsu;
    }
}
