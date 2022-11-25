package boj.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS_5014 {

    static int bfs(int F, int S, int G, int U, int D){
        boolean[] visited = new boolean[F+1];
        Queue<Floor> q = new LinkedList<>();
        q.add(new Floor(S,0));
        while(!q.isEmpty()){
            Floor cur = q.poll();
            if(cur.floor==G){
                return cur.cnt;
            }
            int up = cur.floor+U;
            int down = cur.floor-D;
            if(up <= F && !visited[up]){
                visited[up] = true;
                q.add(new Floor(up,cur.cnt+1));
            }
            if(down >= 1 && !visited[down]){
                visited[down] = true;
                q.add(new Floor(down, cur.cnt+1));
            }
        }
        return -1;
    }
    public static String solution(int F, int S, int G, int U, int D){
        int result = bfs(F,S,G,U,D);
        if(result == -1){
            return "use the stairs";
        }
        else{
            return String.valueOf(result);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int F,S,G,U,D;
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        bw.write(solution(F,S,G,U,D));
        bw.flush();
        bw.close();
    }
}
class Floor{
    int floor;
    int cnt;
    public Floor(int floor, int cnt){
        this.floor=floor;
        this.cnt=cnt;
    }
}
