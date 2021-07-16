package boj.dfs;

import java.io.*;
import java.util.StringTokenizer;

public class DFS_9466 {
    static int n;
    static int[] students;
    static boolean[] visited;
    static boolean[] check;
    static int ans;

    public static void dfs(int v){
        visited[v] = true;

        int next = students[v];
        if(visited[next]){
            if(!check[next]){
                for(int temp = next; temp!=v; temp = students[temp]){
                    ans++;
                }
                ans++;
            }
        }
        else
            dfs(next);
        check[v] = true;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            n = Integer.parseInt(br.readLine());
            students = new int[n];
            visited = new boolean[n];
            check = new boolean[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                students[i] = Integer.parseInt(st.nextToken())-1;
            }
            ans=0;
            for (int i = 0; i < n; i++) {
                if(!visited[i])
                    dfs(i);
            }
            bw.write(n-ans + "\n");
        }
        bw.flush();
        bw.close();
    }
}
