package boj.bfs;

import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS_5427 {
    static int w,h;
    static char[][] map;
    static boolean[][] burned;
    static boolean[][] visited;
    static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    static String ans;

    static boolean isMapIn(int dy, int dx){
        if(dy < 0 || dy >= h || dx < 0 || dx >= w)
            return false;
        return true;
    }

    static void solution(){
        Queue<Point> fires = new LinkedList<>();
        Queue<Target> target = new LinkedList<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j] == '*') {
                    fires.add(new Point(j, i));
                    burned[i][j] = true;
                }
                if (map[i][j] == '@') {
                    target.add(new Target(i, j, 0));
                }
            }
        }

        while(!target.isEmpty()) {
            //불 번짐
            int fireLen = fires.size();
            while (fireLen > 0) {
                Point cur = fires.poll();
                int ny, nx;
                for (int i = 0; i < 4; i++) {
                    ny = cur.y + dir[i][0];
                    nx = cur.x + dir[i][1];
                    if (isMapIn(ny, nx) && burned[ny][nx] == false && map[ny][nx] != '#') {
                        burned[ny][nx] = true;
                        map[ny][nx] = '*';
                        fires.add(new Point(nx, ny));
                    }
                }
                fireLen--;
            }
            //상근 이동
            int targetLen = target.size();
            while (targetLen > 0) {
                Target temp = target.poll();
                int ny, nx;
                for (int i = 0; i < 4; i++) {
                    ny = temp.y + dir[i][0];
                    nx = temp.x + dir[i][1];
                    if (isMapIn(ny, nx) && visited[ny][nx] == false && map[ny][nx] == '.') {
                        visited[ny][nx] = true;
                        map[ny][nx] = '@';
                        target.add(new Target(ny, nx, temp.cnt + 1));
                    }
                    if (!isMapIn(ny, nx)) {
                        ans = String.valueOf(temp.cnt + 1);
                        return;
                    }
                }
                targetLen--;
            }
        }
        ans = "IMPOSSIBLE";
        return;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int testCase =  Integer.parseInt(br.readLine());
        while(testCase-- > 0 ){
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new char[h][w];
            visited = new boolean[h][w];
            burned = new boolean[h][w];
            for(int i=0; i<h; i++){
                String str = br.readLine();
                for(int j=0; j<w; j++){
                    map[i][j] = str.charAt(j);
                }
            }
            ans = "";
            solution();
            bw.write(ans+"\n");
        }
        bw.flush();
        bw.close();
    }
    static void print(char[][] map){
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
}
class Target{
    int y;
    int x;
    int cnt;
    public Target(int y, int x, int cnt){
        this.y=y;
        this.x=x;
        this.cnt=cnt;
    }
}
