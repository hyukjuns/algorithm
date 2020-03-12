package samsungsw;

import javax.swing.*;
import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Stack;

public class Sw_17143 {
    static int r,c,m;
    static LinkedList<Jaws>[][] map;
    static LinkedList<Jaws>[][] nextMap;
    static Stack<Jaws> catched = new Stack<>();
    static int[][] direct = {{0,0},{-1,0},{1,0},{0,1},{0,-1}};

    static void print(int cnt){
        System.out.println(cnt);
        for(int i=1; i<=r; i++){
            for(int j=1; j<=c; j++){
                if(!map[i][j].isEmpty()){
                    System.out.print(map[i][j].get(0).size+" ");
                }
                else{
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    static void solve(){
        int fisherIdx=1;

        while(fisherIdx <= c){
            //다음 맵 상태 초기화
            nextMap = new LinkedList[r+1][c+1];
            for(int i=0; i<=r; i++){
                for(int j=0; j<=c; j++){
                    nextMap[i][j] = new LinkedList<>();
                }
            }
            int targetRowIdx = 1000;
           // print(fisherIdx);

            for(int i=1; i<=r; i++){
                if(!map[i][fisherIdx].isEmpty()){
                    targetRowIdx = i;
                    break;
                }
            }
            //2. 낚시왕이 있는 열에 있는 상어 중에서 땅과 제일 가까운 상어를 잡는다. 상어를 잡으면 격자판에서 잡은 상어가 사라진다.
            if(targetRowIdx != 1000){//잡을 물고기가 있다면
                catched.add(map[targetRowIdx][fisherIdx].poll());
            }
            //3. 상어가 이동한다.
            for(int i=1; i<=r; i++){
                for(int j=1; j<=c; j++){
                    if(!map[i][j].isEmpty()){
                        Jaws cur = map[i][j].get(0);
                        int s = cur.speed;
                        int d = cur.dir;
                        int cnt=0;
                        int ny,nx;
                        int dy = cur.y;
                        int dx = cur.x;
                        while(++cnt <= s){
                            ny = dy + direct[d][0];
                            nx = dx + direct[d][1];
                            //상어가 이동하려고 하는 칸이 격자판의 경계인 경우에는 방향을 반대로 바꿔서 속력을 유지한채로 이동한다.
                            if(ny>r || ny<1 || nx>c || nx<1){ //경계일때
                                if(d==1) {
                                    d = 2;
                                }
                                else if(d==2) {
                                    d=1;
                                }
                                else if(d==3) {
                                    d=4;
                                }
                                else if(d==4) {
                                    d=3;
                                }
                                --cnt;
                                continue;
                            }
                            dy = ny;
                            dx = nx;
                        }
                        cur.y = dy;
                        cur.x = dx;
                        cur.dir = d;
                        nextMap[dy][dx].addLast(cur);
                    }
                }
            }

            //상어가 이동을 마친 후에 한 칸에 상어가 두 마리 이상 있을 수 있다. 이때는 크기가 가장 큰 상어가 나머지 상어를 모두 잡아먹는다.
            for(int i=1; i<=r; i++){
                for(int j=1; j<=c; j++){
                    if(nextMap[i][j].size()>1){
                        int idx=0;
                        int max = nextMap[i][j].get(0).size;
                        for(int k=0; k<nextMap[i][j].size(); k++){
                            if(max < nextMap[i][j].get(k).size){
                                max = nextMap[i][j].get(k).size;
                                idx = k;
                            }
                        }
                        Jaws temp = nextMap[i][j].remove(idx);
                        nextMap[i][j].clear();
                        nextMap[i][j].add(temp);
                    }
                }
            }
            //1. 낚시왕이 오른쪽으로 한 칸 이동한다.
            fisherIdx++;

            //맵복사
            for(int i=0; i<=r; i++){
                for(int j=0; j<=c; j++){
                    map[i][j] = nextMap[i][j];
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new LinkedList[r+1][c+1];
        for(int i=0; i<=r; i++){
            for(int j=0; j<=c; j++){
                map[i][j] = new LinkedList<>();
            }
        }
        int y,x,s,d,z;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            y = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            z = Integer.parseInt(st.nextToken());
            map[y][x].add(new Jaws(y,x,s,d,z));
        }
        solve();

        int answer=0;
        for(int i=0; i<catched.size(); i++){
            answer += catched.get(i).size;
        }
        bw.write(answer+"");
        bw.flush();
        bw.close();
    }
}
class Jaws{
    int y;
    int x;
    int speed, dir, size;
    public Jaws(int y, int x, int speed, int dir, int size){
        this.y=y;
        this.x=x;
        this.speed=speed;
        this.dir=dir;
        this.size=size;
    }
}
