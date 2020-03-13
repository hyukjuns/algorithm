package samsungsw;

import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sw_5644 {
    static int[][] check;
    static LinkedList<BC> BCList;
    static int[][] dir = {{0,0},{-1,0},{0,1},{1,0},{0,-1}};
    static LinkedList<BC>[][] map;
    static boolean[][] visited;
    static int sum1,sum2;
    static void bfs(BC bc){
        int y = bc.y;
        int x = bc.x;
        int c = bc.c;
        int p = bc.p;
        Queue<DOT2> q = new LinkedList<>();
        q.add(new DOT2(y,x,0));
        visited[y][x] = true;
        map[y][x].add(bc);
        while(!q.isEmpty()){
            DOT2 cur = q.poll();
            int ny,nx;
            if(cur.cnt<c) {
                for (int i = 1; i <= 4; i++) {
                    ny = cur.y + dir[i][0];
                    nx = cur.x + dir[i][1];
                    if (ny > 10 || ny < 1 || nx > 10 || nx < 1) continue;
                    if (!visited[ny][nx]) {
                        q.add(new DOT2(ny, nx, cur.cnt + 1));
                        visited[ny][nx] = true;
                        map[ny][nx].add(bc);
                    }
                }
            }
        }
    }
    static void move(int[] p1, int[] p2, int m){
        int ny1, nx1;
        int ny2, nx2;
        int direct1,direct2;
        int p1y=1;
        int p1x=1;
        int p2y=10;
        int p2x=10;

        for(int i=0; i<=m; i++){
            direct1 = p1[i];
            direct2 = p2[i];
            ny1 = p1y + dir[direct1][0];
            nx1 = p1x + dir[direct1][1];
            ny2 = p2y + dir[direct2][0];
            nx2 = p2x + dir[direct2][1];
            if(!map[ny1][nx1].isEmpty() && !map[ny2][nx2].isEmpty()){
                int idx1=0;
                int idx2=0;
                boolean isSameBCArea=false;
                while(idx2<map[ny2][nx2].size()){
                    if(map[ny1][nx1].contains(map[ny2][nx2].get(idx2))){
                        idx1 = map[ny1][nx1].indexOf(map[ny2][nx2].get(idx2));
                        isSameBCArea = true;
                        break;
                    }
                    idx2++;
                }
                if(isSameBCArea){
                    int maxSum=0;
                    int maxIdx1=0,maxIdx2=0;
                    for(int k=0; k<map[ny1][nx1].size(); k++){
                        for(int l=0; l<map[ny2][nx2].size(); l++){
                            if(maxSum < map[ny1][nx1].get(k).p+map[ny2][nx2].get(l).p){
                                if(map[ny1][nx1].get(k).id == map[ny2][nx2].get(l).id){
                                    if(maxSum < map[ny1][nx1].get(k).p){
                                        maxIdx1 = k;
                                        maxIdx2 = l;
                                        maxSum = map[ny1][nx1].get(k).p;
                                    }
                                }
                                else {
                                    maxIdx1 = k;
                                    maxIdx2 = l;
                                    maxSum = map[ny1][nx1].get(k).p + map[ny2][nx2].get(l).p;
                                }
                            }
                        }
                    }
                    check[0][i] = map[ny1][nx1].get(maxIdx1).p;
                    check[1][i] = map[ny2][nx2].get(maxIdx2).p;
                    if(map[ny1][nx1].get(maxIdx1).id == map[ny2][nx2].get(maxIdx2).id){
                        sum1 += map[ny1][nx1].get(maxIdx1).p/2;
                        sum2 += map[ny2][nx2].get(maxIdx2).p/2;
                    }
                    else {
                        sum1 += map[ny1][nx1].get(maxIdx1).p;
                        sum2 += map[ny2][nx2].get(maxIdx2).p;
                    }
                }
                else{
                    int maxSum=map[ny1][nx1].get(0).p;
                    int maxIdx=0;
                    for(int l=1; l<map[ny1][nx1].size(); l++){
                        if(maxSum < map[ny1][nx1].get(l).p){
                            maxIdx = l;
                            maxSum = map[ny1][nx1].get(l).p;
                        }
                    }
                    sum1 += map[ny1][nx1].get(maxIdx).p;
                    check[0][i] = map[ny1][nx1].get(maxIdx).p;

                    maxSum=map[ny2][nx2].get(0).p;
                    maxIdx=0;
                    for(int l=1; l<map[ny2][nx2].size(); l++){
                        if(maxSum < map[ny2][nx2].get(l).p){
                            maxIdx = l;
                            maxSum = map[ny2][nx2].get(l).p;
                        }
                    }
                    check[1][i] = map[ny2][nx2].get(maxIdx).p;
                    sum2 += map[ny2][nx2].get(maxIdx).p;
                }
            }
            else if(!map[ny1][nx1].isEmpty() && map[ny2][nx2].isEmpty()){
                int maxSum=map[ny1][nx1].get(0).p;
                int maxIdx=0;
                for(int l=1; l<map[ny1][nx1].size(); l++){
                    if(maxSum < map[ny1][nx1].get(l).p){
                        maxIdx = l;
                        maxSum = map[ny1][nx1].get(l).p;
                    }
                }
                check[0][i] = map[ny1][nx1].get(maxIdx).p;
                sum1 += map[ny1][nx1].get(maxIdx).p;
            }
            else if(map[ny1][nx1].isEmpty() && !map[ny2][nx2].isEmpty()) {
                int maxSum=map[ny2][nx2].get(0).p;
                int maxIdx=0;
                for(int l=1; l<map[ny2][nx2].size(); l++){
                    if(maxSum < map[ny2][nx2].get(l).p){
                        maxIdx = l;
                        maxSum = map[ny2][nx2].get(l).p;
                    }
                }
                check[1][i] = map[ny2][nx2].get(maxIdx).p;
                sum2 += map[ny2][nx2].get(maxIdx).p;
            }
            p1y = ny1;
            p1x = nx1;
            p2y = ny2;
            p2x = nx2;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());

        for(int i=1; i<=testCase; i++){
            sum1 = sum2 =0;
            map = new LinkedList[11][11];
            BCList = new LinkedList<>();
            for(int k=0; k<11; k++){
                for(int l=0; l<11; l++){
                    map[k][l] = new LinkedList();
                }
            }
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int[] person1 = new int[m+1];
            int[] person2 = new int[m+1];

            check = new int[2][m+1];
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=m; j++){
                person1[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=m; j++){
                person2[j] = Integer.parseInt(st.nextToken());
            }

            for(int j=1; j<=a; j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                BCList.addLast(new BC(j,y,x,c,p));
            }

            for(int j=0; j<BCList.size(); j++){
                visited = new boolean[11][11];
                bfs(BCList.get(j));
            }
            move(person1,person2,m);
            //print(m);
            System.out.println("#"+i+" "+(sum1+sum2));
        }
    }
    static void print(int m){
        for(int i=1; i<=10; i++){
            for(int j=1; j<=10; j++){
                if(!map[i][j].isEmpty())
                    System.out.print(map[i][j].size()+" ");
                else{
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
        for(int i=0; i<2; i++){
            for(int j=0; j<=m; j++){
                System.out.print(check[i][j]+" ");
            }
            System.out.println();
        }
    }
}
class BC{
    int id;
    int y;
    int x;
    int c;
    int p;
    public BC(int id,int y, int x, int c, int p){
        this.id = id;
        this.y = y;
        this.x = x;
        this.c = c;
        this.p = p;
    }
}
class DOT2{
    int y;
    int x;
    int cnt;
    public DOT2(int y, int x, int cnt){
        this.y=y;
        this.x=x;
        this.cnt=cnt;
    }
}
