package boj.Simulation;

import java.awt.*;
import java.io.*;
import java.util.*;

public class Simul_2638 {
    static int row,col;
    static int[][] map;
    static boolean[][] visited;
    static HashSet<Point> hs = new HashSet<>();
    static Queue<Point> edges = new LinkedList<>();
    static int[][] dir = {{0,1},{-1,0},{0,-1},{1,0}};

    public static boolean isValid(int dy, int dx){
        return (dy >=0 && dy < row) && (dx >=0 && dx <col) ? true : false;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        map = new int[row][col];
        for(int i=0; i<row; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<col; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time=0;
        while(true){
            visited = new boolean[row][col];
            hs = new HashSet<>();
            edges = new LinkedList<>();
            bfs(0,0,2);
//            for(int i=0; i<row; i++){
//                for(int j=0; j<col; j++){
//                    System.out.print(map[i][j]+" ");
//                }
//                System.out.println();
//            }
            if(edges.isEmpty()) break;
            while(!edges.isEmpty()){
                Point temp = edges.poll();
                map[temp.y][temp.x] = 0;
            }
            for(int i=0; i<row; i++){
                for(int j=0; j<col; j++){
                    if(map[i][j]==2)
                        map[i][j]=0;
                }
            }
            time++;
        }
        bw.write(time+"");
        bw.flush();
        bw.close();
    }
    public static void bfs(int dy, int dx, int air){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(dx,dy));
        visited[dy][dx] = true;
        while(!q.isEmpty()){
            Point temp = q.poll();
            int ny,nx;
            for(int i=0; i<4; i++){
                ny = temp.y + dir[i][0];
                nx = temp.x + dir[i][1];
                if(isValid(ny,nx) && map[ny][nx]==0 && !visited[ny][nx]){
                    q.add(new Point(nx,ny));
                    visited[ny][nx] = true;
                    map[ny][nx] = air;
                }
                else if(isValid(ny,nx) && map[ny][nx]==1 && !visited[ny][nx]){
                   visited[ny][nx] = true;
                }
                else if(isValid(ny,nx) && map[ny][nx]==1 && visited[ny][nx]){
                    edges.add(new Point(nx,ny));
                }
            }
        }
    }
}
