package boj.Simulation;

import java.io.*;
import java.util.*;

public class Simul_16235 {
    static int n,m,k;
    static int[][] map;//땅의 양분의 양;
    static int[][] refill;//로봇이 추가하는 양분의 양;
    static int[][] dead;
    static Deque<Tree> trees;
    static int[][] getDir = {{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}};
    public static void solve(){
       while(k-->0) {
           spring_summer();
           fall();
           winter();
       }
    }
    static void spring_summer(){

        for (int i=0; i<trees.size();) {
            Tree cur = trees.poll();
            //봄에는 나무가 자신의 나이만큼 양분을 먹고, 나이가 1 증가한다.
            // 각각의 나무는 나무가 있는 1×1 크기의 칸에 있는 양분만 먹을 수 있다. 하나의 칸에 여러 개의 나무가 있다면, 나이가 어린 나무부터 양분을 먹는다.
            if (map[cur.y][cur.x] >= cur.year) {
                map[cur.y][cur.x] -= cur.year;
                cur.year++;
                i++;
                trees.add(cur);
            } else {
                //만약, 땅에 양분이 부족해 자신의 나이만큼 양분을 먹을 수 없는 나무는 양분을 먹지 못하고 즉시 죽는다.
                //여름에는 봄에 죽은 나무가 양분으로 변하게 된다. 각각의 죽은 나무마다 나이를 2로 나눈 값이 나무가 있던 칸에 양분으로 추가된다. 소수점 아래는 버린다.
                dead[cur.y][cur.x] += cur.year/2;
            }
        }
        //만약, 땅에 양분이 부족해 자신의 나이만큼 양분을 먹을 수 없는 나무는 양분을 먹지 못하고 즉시 죽는다.
        //여름에는 봄에 죽은 나무가 양분으로 변하게 된다. 각각의 죽은 나무마다 나이를 2로 나눈 값이 나무가 있던 칸에 양분으로 추가된다. 소수점 아래는 버린다.
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                map[i][j] += dead[i][j];
                dead[i][j] = 0;
            }
        }
    }
    static void fall(){
        //가을에는 나무가 번식한다.
        // 번식하는 나무는 나이가 5의 배수이어야 하며, 인접한 8개의 칸에 나이가 1인 나무가 생긴다.
        Deque<Tree> temp = new LinkedList<>();
        for (Tree cur : trees) {
            if (cur.year % 5 == 0) {
                int ny, nx;
                int r = cur.y;
                int c = cur.x;
                for (int i = 0; i < 8; i++) {
                    ny = r + getDir[i][0];
                    nx = c + getDir[i][1];
                    if ((ny >= 0 && ny < n) && (nx >= 0 && nx < n)) {
                        temp.offer(new Tree(ny, nx, 1));
                    }
                }
            }
        }
        //하나의 칸에 여러 개의 나무가 있다면, 나이가 어린 나무부터 양분을 먹는다.
        for(Tree tempIter : temp){
            trees.offerFirst(tempIter);
        }
    }
    static void winter(){
        //겨울에는 S2D2가 땅을 돌아다니면서 땅에 양분을 추가한다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] += refill[i][j];
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        refill = new int[n][n];
        dead = new int[n][n];
        trees = new LinkedList<>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                refill[i][j] = Integer.parseInt(st.nextToken());
                map[i][j] = 5;
            }
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            trees.offer(new Tree(y-1,x-1,year));
        }

        solve();
        bw.write(trees.size()+"");
        bw.flush();
        bw.close();
    }
}
class Tree{
    int y;
    int x;
    int year;
    public Tree(int y,int x, int year){
        this.y = y;
        this.x = x;
        this.year = year;
    }
}
