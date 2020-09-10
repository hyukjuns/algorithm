package boj.bfs;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_2667 {
    static int n;
    static int[][] graph;
    static boolean[][] visited;
    static int[][] dir = {{0,1},{-1,0},{0,-1},{1,0}}; // (y,x) == (행, 열) 동 북 서 남
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        visited = new boolean[n][n];
        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<n; j++){
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        int idx=0; //단지번호
        ArrayList<Integer> numberOfHouses = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(graph[i][j]!=0 && !visited[i][j]){
                    numberOfHouses.add(bfs(i,j,++idx));
                }
            }
        }
        Collections.sort(numberOfHouses);
        bw.write(idx+"\n");
        for(int i=0; i<numberOfHouses.size(); i++){
            bw.write(numberOfHouses.get(i)+"\n");
        }
        bw.flush();
        bw.close();
    }
    public static int bfs(int dy, int dx, int idx){
        visited[dy][dx] = true;
        graph[dy][dx] = idx;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(dx,dy));
        int house=0;
        while(!q.isEmpty()){
            Point temp = q.poll();
            house++;
            int ny, nx;
            for(int i=0; i<4; i++){
                ny = temp.y + dir[i][0];
                nx = temp.x + dir[i][1];
                if(isValid(ny,nx) && graph[ny][nx] != 0 && !visited[ny][nx]){
                    visited[ny][nx] = true;
                    graph[ny][nx] = idx;
                    q.add(new Point(nx,ny));
                }
            }
        }
        return house;
    }
    public static boolean isValid(int dy, int dx){
        return ((dy>=0 && dy<n) && (dx>=0 && dx<n)) ? true : false;
    }
}