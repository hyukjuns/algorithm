package boj.bfs;

import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_10026 {
    private static int n;
    private static char graph[][];
    private static boolean visited[][];

    public static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    public static boolean isValid(int y, int x){
        return (y>=0 && y<n) && (x>=0 && x<n) ? true : false;
    }
    public static void bfs(int y, int x, boolean isColor){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x,y));
        visited[y][x] = true;
        char target = graph[y][x];
        while(!q.isEmpty()){
            Point cur = q.poll();
            int nextY,nextX;
            for(int i=0; i<4; i++){
                nextY = cur.y + dir[i][0];
                nextX = cur.x + dir[i][1];
                if(isValid(nextY,nextX)){
                    if(!isColor){//적록색약이 아닌경우;
                        if(!visited[nextY][nextX] && graph[nextY][nextX] == target){
                            q.add(new Point(nextX,nextY));
                            visited[nextY][nextX] = true;
                        }
                    }
                    else{//적록색약인 경우;
                        if(target == 'R' || target == 'G'){ //R과 G를 같은색으로 생각;
                            if(!visited[nextY][nextX] && graph[nextY][nextX] != 'B' ){
                                q.add(new Point(nextX,nextY));
                                visited[nextY][nextX] = true;
                            }
                        }
                        else if(target=='B'){
                            if(!visited[nextY][nextX] && graph[nextY][nextX] == target ){
                                q.add(new Point(nextX,nextY));
                                visited[nextY][nextX] = true;
                            }
                        }
                    }
                }
            }
        }

    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        graph = new char[n][n];
        visited = new boolean[n][n];
        String str;
        for(int i=0; i<n; i++){
            str = br.readLine();
            for(int j=0; j<n; j++){
                graph[i][j] = str.charAt(j);
            }
        }

        int cnt=0;
        boolean isColor = false;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j]) {
                    bfs(i, j, isColor);
                    cnt++;
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
               visited[i][j] = false;
            }
        }
        int cnt2=0;
        isColor = true;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j]) {
                    bfs(i, j, isColor);
                    cnt2++;
                }
            }
        }
        bw.write(cnt+" "+cnt2);
        bw.flush();
        bw.close();
    }
}