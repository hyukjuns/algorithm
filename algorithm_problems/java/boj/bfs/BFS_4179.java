package boj.bfs;

import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS_4179 {
    static int r, c;
    static char[][] map;
    static boolean[][] visited;
    static boolean[][] burned;
    static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    static String ans = "";

    static boolean isMapIn(int dy, int dx){
        if(dy < 0 || dy >= r || dx < 0 || dx >= c)
            return false;
        return true;
    }

    public static void solution(){
        Queue<Point> fires = new LinkedList<>();
        Queue<Target> target = new LinkedList<>();
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(map[i][j] == 'F') {
                    fires.add(new Point(j, i));
                    burned[i][j] = true;
                }
                else if(map[i][j]=='J') {
                    target.add(new Target(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        while(!target.isEmpty()){
            int fireLen = fires.size();
            while(fireLen >0){
                Point temp = fires.poll();
                int ny,nx;
                for(int i=0; i<4; i++){
                    ny = temp.y + dir[i][0];
                    nx = temp.x + dir[i][1];
                    if(isMapIn(ny,nx) && !burned[ny][nx] && map[ny][nx] != '#'){
                        map[ny][nx] = 'F';
                        burned[ny][nx] = true;
                        fires.add(new Point(nx,ny));
                    }
                }
                fireLen--;
            }
            int targetLen = target.size();
            while(targetLen >0){
                Target temp = target.poll();
                int ny,nx;
                for(int i=0; i<4; i++){
                    ny = temp.y + dir[i][0];
                    nx = temp.x + dir[i][1];
                    if(isMapIn(ny,nx) && !visited[ny][nx] && map[ny][nx] == '.'){
                        visited[ny][nx] = true;
                        target.add(new Target(ny,nx,temp.cnt+1));
                    }
                    if(!isMapIn(ny,nx)){
                        ans = String.valueOf(temp.cnt+1);
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        visited = new boolean[r][c];
        burned = new boolean[r][c];
        for(int i=0; i<r; i++){
            String str = br.readLine();
            for(int j=0; j<c; j++){
                map[i][j] = str.charAt(j);
            }
        }
        solution();

        bw.write(ans);
        bw.flush();
        bw.close();

    }
}
