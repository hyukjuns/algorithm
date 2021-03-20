package remind;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Dfs_bfs_1260 {
    static int n, m, v;
    static int[][] map;
    static boolean[] visited;
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        map = new int[n+1][n+1];
        visited = new boolean[n+1];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = map[b][a] = 1;
        }

        //Check dfs
        dfs(v);
        while(!q.isEmpty()){
            bw.write(q.poll()+" ");
        }
        bw.write("\n");
        //Check bfs
        visited = new boolean[n+1];
        bfs(v);
        while(!q.isEmpty()){
            bw.write(q.poll()+" ");
        }
        bw.flush();
        bw.close();
    }
    public static void dfs(int v){
        visited[v] = true;
        q.add(v);
        for(int i=1; i<=n; i++){
            if(map[v][i] != 0 && !visited[i]){
                dfs(i);
            }
        }
    }

    public static void bfs(int v){
        Queue<Integer> tmpQue = new LinkedList<>();
        tmpQue.add(v);
        visited[v]=true;
        while(!tmpQue.isEmpty()){
            int temp = tmpQue.poll();
            q.add(temp);
            for(int i=1; i<=n; i++){
                if(map[temp][i] != 0 && !visited[i]){
                    visited[i] = true;
                    tmpQue.add(i);
                }
            }
        }
    }
}
