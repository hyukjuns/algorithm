package boj.Simulation;

import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Simul_2636 {
    static int row,col;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dir = {{0,1},{-1,0},{0,-1},{1,0}};
    static Queue<Point> touched = new LinkedList<>();

    public static void  main(String[]  args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        map = new int[row][col];
        visited = new boolean[row][col];

        for(int i=0; i<row; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<col; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time=0;
        int beforeEnd=0;
        while(true){
            int air=2;
            visited = new boolean[row][col];
            touched = new LinkedList<>();
            bfs(0,0,air);
            if(touched.isEmpty())   break;
            beforeEnd=0;
            while(!touched.isEmpty()){
                Point temp = touched.poll();
                map[temp.y][temp.x] = 2;
                beforeEnd++;
            }
            for(int i=0; i<row; i++){
                for(int j=0; j<col; j++){
                    if(visited[i][j]){
                        map[i][j] = 0;
                    }
                }
            }
            time++;
//            for(int i=0; i<row; i++){
//                for(int j=0; j<col; j++){
//                    System.out.print(map[i][j]);
//                }
//                System.out.println();
//            }
        }
        bw.write(time+"\n");
        bw.write(beforeEnd+"");
        bw.flush();
        bw.close();

    }
    public static void bfs(int dy, int dx, int air){
        map[dy][dx] = air;
        visited[dy][dx] = true;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(dx,dy));
        while(!q.isEmpty()){
            Point temp = q.poll();
            int ny,nx;
            for(int i=0; i<4; i++){
                ny = temp.y + dir[i][0];
                nx = temp.x + dir[i][1];
                if(isValid(ny,nx) && map[ny][nx] == 0 && !visited[ny][nx]){
                    map[ny][nx] = air;
                    visited[ny][nx] = true;
                    q.add(new Point(nx,ny));
                }
                if(isValid(ny,nx) && map[ny][nx] == 1 && !visited[ny][nx]){
                    visited[ny][nx] = true;
                    touched.add(new Point(nx,ny));
                }
            }
        }
    }
    public static boolean isValid(int dy,int dx){
        return (dy>=0 && dy<row) && (dx >=0 && dx<col) ? true : false;
    }
}
