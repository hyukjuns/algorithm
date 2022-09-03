package samsungsw;

import java.awt.Point;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sw_17144 {
    static int r,c,t;
    static int[][] map;
    static int airRowIdx;
    static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};

    //미세먼지가 확산된다. 확산은 미세먼지가 있는 모든 칸에서 동시에 일어난다.
    static void spreadDust(){
        Queue<Point> dusts = new LinkedList<>();
        int[][] nextMap = new int[r][c];

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                dusts.add(new Point(j,i)); //x,y 열 행
            }
        }

        int ny,nx;
        while(!dusts.isEmpty()){
            Point cur = dusts.poll();
            int cnt=0;
            //(r, c)에 있는 미세먼지는 인접한 네 방향으로 확산된다.
            for(int i=0; i<4; i++){
                ny = cur.y + dir[i][0];
                nx = cur.x + dir[i][1];
                //인접한 방향에 공기청정기가 있거나, 칸이 없으면 그 방향으로는 확산이 일어나지 않는다.
                if(ny>=r || ny<0 || nx>=c || nx<0 || map[ny][nx]==-1)    continue;
                nextMap[ny][nx] += map[cur.y][cur.x] / 5;//확산되는 양은 Ar,c/5이고 소수점은 버린다
                cnt++;
            }
            nextMap[cur.y][cur.x] += map[cur.y][cur.x] - (map[cur.y][cur.x]/5)*cnt;//(r, c)에 남은 미세먼지의 양은 Ar,c - (Ar,c/5)×(확산된 방향의 개수) 이다.
        }

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                map[i][j] = nextMap[i][j];
            }
        }

    }

    //공기청정기가 작동한다.
    static void startAirFilter(){
        //공기청정기에서는 바람이 나온다.
        //위쪽 공기청정기의 바람은 반시계방향으로 순환하고, 아래쪽 공기청정기의 바람은 시계방향으로 순환한다.
        //바람이 불면 미세먼지가 바람의 방향대로 모두 한 칸씩 이동한다.
        //공기청정기에서 부는 바람은 미세먼지가 없는 바람이고, 공기청정기로 들어간 미세먼지는 모두 정화된다.
        int up = airRowIdx-1;
        int down = airRowIdx;

        //up
        //시계방향
        int row = up;
        while(--row > -1){
            if(map[row+1][0]==-1){
                map[row][0]=0;
            }
            else{
                map[row+1][0] = map[row][0];
            }
        }
        row = 0;
        int col = 0;
        while(++col < c){
            map[row][col-1] = map[row][col];
        }
        col = c-1;
        while(++row <= up){
            map[row-1][col] = map[row][col];
        }
        row = up;
        while(--col > 0){
            map[row][col+1] = map[row][col];
        }
        map[row][col+1] = 0;

        //down
        //반시계방향
        row = down;
        while(++row < r){
            if(map[row-1][0] == -1){
                map[row][0] = 0;
            }
            else{
                map[row-1][0] = map[row][0];
            }
        }
        row = r-1;
        col = 0;
        while(++col < c){
            map[row][col-1] = map[row][col];
        }
        col = c-1;
        while(--row >= down){
            map[row+1][col] = map[row][col];
        }
        row = down;
        while(--col > 0){
            map[row][col+1] = map[row][col];
        }
        map[row][col+1] = 0;


    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        map = new int[r][c];
        for(int i=0; i<r; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<c; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == -1){
                    airRowIdx = i;
                }
            }
        }


        while(t-- > 0){
            spreadDust();
            startAirFilter();
            //print();
        }

        int sum=0;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(map[i][j] != -1)
                    sum += map[i][j];
            }
        }
        System.out.println(sum);

    }
    static void print(){
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
}
