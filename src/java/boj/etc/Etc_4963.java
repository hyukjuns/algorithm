package boj.etc;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Etc_4963 {
    static int w,h;
    static int[][] map;
    static int[][] dir = {{0,1}, {0,-1}, {1,0},{-1,0},{-1,1},{1,1},{1,-1},{-1,-1}};
    public static void bfs(int y, int x, int landCnt) {
        Queue<DOT> q = new LinkedList<>();
        q.offer(new DOT(y, x));
        while (!q.isEmpty()) {
            DOT cur = q.poll();
            int ny, nx;
            for (int i = 0; i < dir.length; i++) {
                ny = cur.y + dir[i][0];
                nx = cur.x + dir[i][1];
                if (ny >= 0 && ny < h && nx >= 0 && nx < w) {
                    if(map[ny][nx] == 1) {
                        map[ny][nx] = landCnt;
                        q.offer(new DOT(ny,nx));
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while(true){
            int landCnt=1;
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(w == 0 && h == 0)
                break;
            map = new int[h][w];
            for(int i=0; i<h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<w; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(map[i][j] == 1)
                        bfs(i,j,++landCnt);
                }
            }
            bw.write(landCnt-1+"\n");
        }
        bw.flush();
        bw.close();
    }
}
class DOT{
    int y;
    int x;
    public DOT(int y, int x){
        this.y = y;
        this.x = x;
    }
}
