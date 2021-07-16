package boj.bfs;//7562 나이트의 이동 bfs

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS_7562 {
    static boolean[][] visited = null;
    static int sizeOfMap;
    static int[][] dir = {{-2,-1},{-1,-2},{-2,1},{-1,2},{1,2},{2,1},{1,-2},{2,-1}};

    public static boolean isValid(int dy,int dx){
        return (dy>=0 && dy<sizeOfMap) && (dx>=0 && dx<sizeOfMap);
    }
    public static int bfs(int y, int x, int endy, int endx){
        visited[y][x] = true;
        Queue<CNT_DOT> q = new LinkedList<>();
        q.add(new CNT_DOT(0,y,x));
        int cnt=0;

        while(!q.isEmpty()){
            CNT_DOT temp = q.poll();
            cnt = temp.cnt;
            if(temp.y==endy && temp.x==endx){
                 break;
            }
            int dy,dx;
            for(int i=0; i<8; i++){
                dy = temp.y + dir[i][0];
                dx = temp.x + dir[i][1];
                if(isValid(dy,dx) && !visited[dy][dx]){
                    visited[dy][dx] = true;
                    q.add(new CNT_DOT(cnt+1,dy,dx));
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int tc = Integer.parseInt(br.readLine());
        for(int i=0; i<tc; i++){
            sizeOfMap = Integer.parseInt(br.readLine());
            visited = new boolean[sizeOfMap][sizeOfMap];
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int endy = Integer.parseInt(st.nextToken());
            int endx = Integer.parseInt(st.nextToken());
            int res =  bfs(y,x,endy,endx);
            bw.write(res+"\n");
        }
        bw.flush();
        bw.close();
    }
}
class CNT_DOT{
    int cnt;
    int y;
    int x;
    public CNT_DOT(int cnt, int y, int x){
        this.cnt = cnt;
        this.y = y;
        this.x = x;
    }
}
