package boj.Simulation;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Simul_5567 {
    static int n,m;
    static int[][] map;
    static boolean[] visited;

    public static void bfs(int v){
        Queue<Friend> q = new LinkedList<>();
        q.add(new Friend(v,0));

        while(!q.isEmpty()){
            Friend temp = q.poll();
            if(temp.cnt>=2)
                break;
            for(int i=0; i<n; i++){
                if(map[temp.val][i] == 1 && !visited[i]){
                    visited[i] = true;
                    q.add(new Friend(i,temp.cnt+1));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        map =  new int[n][n];
        visited = new boolean[n];
        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            map[a][b] = map[b][a] = 1;
        }
        bfs(0);
        int ans=0;
        for(int i=1; i<n; i++){
            if(visited[i])  ans++;
        }
        bw.write(ans+"");
        bw.flush();
        bw.close();
    }
}
class Friend{
    int val;
    int cnt;
    public Friend(int val, int cnt){
        this.val = val;
        this.cnt = cnt;
    }
}
