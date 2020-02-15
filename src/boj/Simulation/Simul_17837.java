package boj.Simulation;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Simul_17837 {
    static int n,k;
    static int[][] map;
    static LinkedList<knight> knights = new LinkedList<>();
    static LinkedList<Integer>[][] getMapStatus;
    static int[][] getDir = {{0,1},{1,0},{0,-1},{-1,0}}; //동남서북 0 1 2 3
    static int turnCnt=0;

    public static boolean isInside(int dy, int dx){
        return (dy>=0 && dy<n)&&(dx>=0 && dx<n) ? true : false;
    }
    public static void white(int i, int dy,int dx, int dir, int ny, int nx){
        LinkedList<Integer> temp = new LinkedList<>();
        int idx = getMapStatus[dy][dx].indexOf(i);
        int len = getMapStatus[dy][dx].size();
        for(int g=idx; g<len; g++){
            knights.get(getMapStatus[dy][dx].get(g)).y = ny;
            knights.get(getMapStatus[dy][dx].get(g)).x = nx;//다음위치 저장;
        }
        //A번 말의 위에 다른 말이 있는 경우에는 A번 말과 위에 있는 모든 말이 이동한다.
        //예를 들어, A, B, C로 쌓여있고, 이동하려는 칸에 D, E가 있는 경우에는 A번 말이 이동한 후에는 D, E, A, B, C가 된다.
        for(int g=idx; g<len; g++){
            temp.add(getMapStatus[dy][dx].pollLast());
        }
        while(!temp.isEmpty()){
            getMapStatus[ny][nx].add(temp.pollLast());
        }
    }
    public static void red(int i, int dy,int dx, int dir, int ny, int nx){
        LinkedList<Integer> temp = new LinkedList<>();
        int idx = getMapStatus[dy][dx].indexOf(i);
        int len = getMapStatus[dy][dx].size();
        for(int g=idx; g<len; g++){
            knights.get(getMapStatus[dy][dx].get(g)).y = ny;
            knights.get(getMapStatus[dy][dx].get(g)).x = nx;
        }
        //A, B, C가 이동하고, 이동하려는 칸에 말이 없는 경우에는 C, B, A가 된다.
        //A, D, F, G가 이동하고, 이동하려는 칸에 말이 E, C, B로 있는 경우에는 E, C, B, G, F, D, A가 된다.
        for(int g=idx; g<len; g++){
            temp.add(getMapStatus[dy][dx].pollLast());
        }
        while(!temp.isEmpty()){
            getMapStatus[ny][nx].add(temp.pollFirst());
        }
    }
    public static boolean turnStart(){
        int dy, dx, dir;
        int ny,nx;
        for(int i=0; i<k; i++){
            dy = knights.get(i).y;
            dx = knights.get(i).x;
            dir = knights.get(i).dir;
            ny = dy + getDir[dir][0];
            nx = dx + getDir[dir][1];

            //파란색인 경우에는 A번 말의 이동 방향을 반대로 하고 한 칸 이동한다.
            //체스판을 벗어나는 경우에는 파란색과 같은 경우이다.
            if(!isInside(ny,nx) || map[ny][nx] == 2){
                dir = (dir+2) % 4;//반대전환;
                knights.get(i).dir = dir;
                ny = dy + getDir[dir][0];
                nx = dx + getDir[dir][1];
                //방향을 반대로 한 후에 이동하려는 칸이 파란색인 경우에는 이동하지 않고 방향만 반대로 바꾼다.
                if(!isInside(ny,nx) || map[ny][nx] == 2) {
                     //턴이 진행되던 중에 말이 4개 이상 쌓이는 순간 게임이 종료된다.
                    if(getMapStatus[dy][dx].size()>=4)
                        return true;
                    continue;
                }
                else{
                    //흰색인 경우에는 그 칸으로 이동한다. 이동하려는 칸에 말이 이미 있는 경우에는 가장 위에 A번 말을 올려놓는다.
                   if(map[ny][nx]==0)
                       white(i,dy,dx,dir,ny,nx);
                   //빨간색인 경우에는 이동한 후에 A번 말과 그 위에 있는 모든 말의 쌓여있는 순서를 반대로 바꾼다.
                   else if(map[ny][nx]==1)
                        red(i,dy,dx,dir,ny,nx);
                }
            }
            else if(map[ny][nx] == 0){//white
                //흰색인 경우에는 그 칸으로 이동한다. 이동하려는 칸에 말이 이미 있는 경우에는 가장 위에 A번 말을 올려놓는다.
                white(i,dy,dx,dir,ny,nx);
            }
            else if(map[ny][nx] == 1){ //red
                //빨간색인 경우에는 이동한 후에 A번 말과 그 위에 있는 모든 말의 쌓여있는 순서를 반대로 바꾼다.
                red(i,dy,dx,dir,ny,nx);
            }
            //턴이 진행되던 중에 말이 4개 이상 쌓이는 순간 게임이 종료된다.
            if(getMapStatus[ny][nx].size()>=4)
                return true;
        }
        return false;
    }
    public static void solve(){
        while(turnCnt++ < 1000){
            if(turnStart())
                return;
        }
        turnCnt = -1;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        getMapStatus = new LinkedList[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                getMapStatus[i][j] = new LinkedList<>();
            }
        }
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int row,col,dir;
        for(int i=0; i<k; i++){ //말의 이름 1번부터 K번 말까지 숫자로 네이밍
            st = new StringTokenizer(br.readLine());
            row = Integer.parseInt(st.nextToken()) - 1;
            col = Integer.parseInt(st.nextToken()) - 1;
            dir = Integer.parseInt(st.nextToken());
            if(dir==1)//동;
                dir = 0;
            else if(dir==2)//서;
                dir = 2;
            else if(dir==3)//북;
                dir = 3;
            else//남;
                dir = 1;
            knights.add(new knight(row,col,dir));//0~k-1까지
            getMapStatus[row][col].add(i);//0~k-1
        }

        solve();
        bw.write(turnCnt+"");
        bw.flush();
        bw.close();
    }
}
class knight{
    int y;
    int x;
    int dir;
    public knight(int y,int x,int dir){
        this.y=y;
        this.x=x;
        this.dir=dir;
    }
}

