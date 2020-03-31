package boj.Simulation;

import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Simul_3055 {
    static int r,c;
    static char[][] map;
    static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    static boolean[][] visited;
    static boolean[][] visited2;
    static Point d;
    static LinkedList<Go> goes = new LinkedList<>();
    static String ans;

    static void spreadWater(){
        Queue<Point> q = new LinkedList<>();
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(map[i][j] == '*'){
                    q.add(new Point(j,i));
                }
            }
        }

        while(!q.isEmpty()){
            Point temp = q.poll();
            int ny,nx;
            for(int i=0; i<4; i++){
                ny = temp.y + dir[i][0];
                nx = temp.x + dir[i][1];
                if(ny>=r || ny<0 || nx>=c || nx<0 || map[ny][nx] == 'D')  continue;
                if(map[ny][nx]!='X' && !visited[ny][nx]){
                    map[ny][nx] = '*';
                    visited[ny][nx] = true;
                }
            }
        }
    }
    static boolean isSafe(){
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(map[i][j] == 'S'){
                    return true;
                }
            }
        }
        return false;
    }
    static void solution(){
        Queue<Go> go = new LinkedList<>();
        while(true){
            if(!isSafe()){
                ans = "KAKTUS";
                return;
            }
            spreadWater();
            //move
            for(int i=0; i<goes.size(); i++){
                go.add(goes.get(i));
            }
            goes.clear();
            while(!go.isEmpty()){
                Go temp = go.poll();
                int ny,nx;
                for(int i=0; i<4; i++){
                    ny = temp.y + dir[i][0];
                    nx = temp.x + dir[i][1];
                    if(ny>=r || ny<0 || nx>=c || nx<0)  continue;
                    if(map[ny][nx] == 'D'){
                        ans = String.valueOf(temp.cnt+1);
                        return;
                    }
                    if(map[ny][nx]=='.' && !visited2[ny][nx]){
                        visited2[ny][nx] = true;
                        goes.add(new Go(ny,nx,temp.cnt+1));
                        map[ny][nx] = 'S';
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        visited = new boolean[r][c];
        visited2 = new boolean[r][c];
        for(int i=0; i<r; i++){
            String str = br.readLine();
            for(int j=0; j<c; j++){
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'D'){
                    d = new Point(j,i);
                }
                else if(map[i][j]=='S'){
                    goes.add(new Go(i,j,0));
                }
            }
        }
        solution();
        bw.write(ans);
        bw.flush();
        bw.close();
    }

}
class Go {
    int y;
    int x;
    int cnt;
    public Go(int y, int x, int cnt){
        this.y=y;
        this.x=x;
        this.cnt=cnt;
    }
}