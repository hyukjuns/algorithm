package samsungsw.review;

import java.awt.*;
import java.io.*;
import java.util.*;

public class swea_19237 {
    static int n,m,k;
    static int[][][] map;
    static LinkedList<JawsInfo> jawsList = new LinkedList<>();
    static int[][] dir = {{0,0},{-1,0},{1,0},{0,-1},{0,1}};

    public static boolean isValid(int dy, int dx){
        return (dy>=1 && dy<=n) && (dx>=1 && dx<=n) ? true:false;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n+1][n+1][2];
        int[][] currentIdx = new int[m+1][2];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                map[i][j][0] = Integer.parseInt(st.nextToken());
                if(map[i][j][0] != 0) {
                    currentIdx[map[i][j][0]][0]=i;//dy
                    currentIdx[map[i][j][0]][1]=j;//dx
                    map[i][j][1] = k;
                }
                else
                    map[i][j][1] = 0;
            }
        }

        //direct input
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=m; i++){
            jawsList.add(new JawsInfo(i, Integer.parseInt(st.nextToken()), new int[5][6],currentIdx[i][0],currentIdx[i][1]));
        }
        for(int i=1; i<=m; i++){
            JawsInfo temp = jawsList.pollFirst();
            for(int j=1; j<=4; j++){
                st = new StringTokenizer(br.readLine());
                for(int k=1; k<=4; k++){
                    temp.order[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            jawsList.addLast(temp);
        }


        int time=0;
        while(time++ <= 1000){
            HashMap<Integer,JawsInfo> nextJawsList = new HashMap<>();
            //상어이동
            //이동 방향 결정
            //1. 무취, 2. 자신의 냄새 3. 여러가지 경우 존재할 때 우선순위 적용
            int ny,nx;
            int len=jawsList.size();
            for(int i=0; i<len; i++){
                HashMap<Integer,Point> moveList = new HashMap<>();
                JawsInfo curJaws = jawsList.get(i);
                int dy = curJaws.dy;
                int dx = curJaws.dx;
                for(int k=1; k<=4; k++){
                    ny = dy + dir[k][0];
                    nx = dx + dir[k][1];
                    if(isValid(ny,nx) && map[ny][nx][0] == 0){
                        moveList.put(k,new Point(nx,ny));
                    }
                }
                if(moveList.isEmpty()){
                    for(int k=1; k<=4; k++){
                        ny = dy + dir[k][0];
                        nx = dx + dir[k][1];
                        if(isValid(ny,nx) && map[ny][nx][0] == curJaws.num){
                            moveList.put(k,new Point(nx,ny));
                        }
                    }
                }
                if(moveList.isEmpty()){
                    nextJawsList.put(curJaws.num, curJaws);
                    continue;
                }
                int curDirect = curJaws.direct;
                int nextDirect=0;
                for(int k=1; k<=4; k++){
                    if(moveList.containsKey(curJaws.order[curDirect][k])){
                        nextDirect = curJaws.order[curDirect][k];
                        break;
                    }
                }
                curJaws.direct=nextDirect;
                curJaws.dy=moveList.get(nextDirect).y;
                curJaws.dx=moveList.get(nextDirect).x;
                nextJawsList.put(curJaws.num,curJaws);
            }
            //각 격자칸의 남은시간 감소
            for(int j=1; j<=n; j++){
                for(int k=1; k<=n; k++){
                    if(map[j][k][0] != 0)   map[j][k][1]--;
                    if(map[j][k][1]==0) map[j][k][0]=0;
                }
            }
            //새로운 상어들의 장소를 맵에 기록
            Queue<Integer> outList = new LinkedList<>();
            for(JawsInfo temp : nextJawsList.values()){
                if(map[temp.dy][temp.dx][0] != 0){
                    //1. 자신의 채취
                    if(map[temp.dy][temp.dx][0] == temp.num){
                        map[temp.dy][temp.dx][0]=temp.num;
                        map[temp.dy][temp.dx][1]=k;
                    }
                    //2. 다른상어랑 공존
                    else if(map[temp.dy][temp.dx][0] != temp.num){
                        if(map[temp.dy][temp.dx][0] < temp.num){
                            outList.add(temp.num);
                        }else{
                            outList.add(map[temp.dy][temp.dx][0]);
                            map[temp.dy][temp.dx][0]=temp.num;
                            map[temp.dy][temp.dx][1]=k;
                        }
                    }
                }else{
                    map[temp.dy][temp.dx][0]=temp.num;
                    map[temp.dy][temp.dx][1]=k;
                }
            }
            //Out jaws
            while(!outList.isEmpty()){
                int target = outList.poll();
                nextJawsList.remove(target);
            }
            jawsList = new LinkedList<>();
            for(JawsInfo j : nextJawsList.values()){
                jawsList.add(j);
            }
            if(jawsList.size()==1){
                break;
            }
        }
        if(time>1000)   bw.write("-1");
        else    bw.write(time+"");
        bw.flush();
        bw.close();

    }
    public static void print(){
        System.out.println(n+" "+m+" "+k);
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        for(int i=1; i<=m; i++){
            JawsInfo temp = jawsList.poll();
            for(int j=1; j<=4; j++){
                for(int k=1; k<=4; k++){
                    System.out.print(temp.order[j][k]+" ");
                }
                System.out.println();
            }
        }
    }
}

class JawsInfo{
    int num;
    int direct;
    int[][] order;
    int dy,dx;
    public JawsInfo(int num,int direct, int[][] order,int dy, int dx){
        this.num=num;
        this.direct=direct;
        this.order=order;
        this.dy=dy;
        this.dx=dx;
    }
}
