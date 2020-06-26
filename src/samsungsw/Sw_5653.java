package samsungsw;

import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sw_5653 {
    static int n,m,k;
    static Cells[][] grid = new Cells[1001][1001];
    static Cells[][] nextGrid;
    static boolean[][] visited;
    static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};

    static void print(Cells[][] test){
        for(int i=0; i<test.length; i++){
            for(int j=0; j<test[i].length; j++){
                System.out.print(test[i][j].life+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    static void bfs(int dy, int dx){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(dx,dy));
        int life = nextGrid[dy][dx].life;
        int ny,nx;

        for(int i=0; i<4; i++){
            ny = dy + dir[i][0];
            nx = dx + dir[i][1];
            if(!visited[ny][nx] && nextGrid[ny][nx].life == 0 && !nextGrid[ny][nx].isDead){
                nextGrid[ny][nx].life = life;
            }
            else if(!visited[ny][nx] && nextGrid[ny][nx].life != 0 && !nextGrid[ny][nx].isDead){
                if(nextGrid[ny][nx].life < life){
                    nextGrid[ny][nx].life = life;
                }
            }
        }
    }
    static void solve(){
        int time=0;
        while(time++ < k){
            //맵증가
            nextGrid = new Cells[1001][1001];
            visited = new boolean[1001][1001];
            for(int i=0; i<1001; i++){
                for(int j=0; j<1001; j++){
                    nextGrid[i][j] = new Cells(0,0,false,false);
                }
            }
            for(int i=0; i<1001; i++) {
                for (int j = 0; j < 1001; j++) {
                    nextGrid[i][j] = grid[i][j];
                    if(grid[i][j].life != 0){
                        visited[i][j] = true;
                    }
                }
            }
            for(int i=0; i<1001; i++){
                for(int j=0; j<1001; j++){
                    if(visited[i][j] && nextGrid[i][j].life != 0 && !nextGrid[i][j].isRunable && !nextGrid[i][j].isDead){
                        nextGrid[i][j].timeCnt++;
                        if(nextGrid[i][j].timeCnt == nextGrid[i][j].life){
                            nextGrid[i][j].isRunable = true;
                        }
                    }
                    else if(visited[i][j] && nextGrid[i][j].life != 0 && nextGrid[i][j].isRunable && !nextGrid[i][j].isDead){
                        bfs(i,j);
                        nextGrid[i][j].timeCnt--;
                        if(nextGrid[i][j].timeCnt==0){
                            nextGrid[i][j].isDead = true;
                        }
                    }
                }
            }//print(nextGrid);
            grid = new Cells[1001][1001];
            for(int i=0; i<1001; i++){
                for(int j=0; j<1001; j++){
                    grid[i][j] = nextGrid[i][j];
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());
        int tc=0;
        while(tc++ < testCase){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            for(int i=0; i<1001; i++){
                for(int j=0; j<1001; j++){
                    grid[i][j] = new Cells(0,0,false,false);
                }
            }
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<m; j++){
                    int life = Integer.parseInt(st.nextToken());
                    grid[500+i][500+j] = new Cells(life,0,false,false);
                }
            }
            solve();
            int ans=0;
            for(int i=0; i<nextGrid.length; i++){
                for(int j=0; j<nextGrid[i].length; j++){
                    if(nextGrid[i][j].life != 0 && !nextGrid[i][j].isDead){
                        ans++;
                    }
                }
            }
            bw.write("#"+tc+" "+ans+"\n");
        }
        bw.flush();
        bw.close();
    }
}
class Cells {
    int life;
    int timeCnt;
    boolean isRunable;
    boolean isDead;
    public Cells(int life, int timeCnt, boolean isRunable, boolean isDead){
        this.life = life;
        this.timeCnt = timeCnt;
        this.isRunable = isRunable;
        this.isDead = isDead;
    }
}

