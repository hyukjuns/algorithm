package samsungsw;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Sw_15685 {
    static int n;
    static int[][] map;
    static int[][] dragons;
    static int[][] getDir = {{1,0},{0,-1},{-1,0},{0,1}}; //0 1 2 3

    public static void makeDragon(int dx, int dy, int dir, int maxGeneration){
        LinkedList<Integer> dirInfo = new LinkedList<>();
        LinkedList<Integer> temp = new LinkedList<>();
        dirInfo.add(dir);//0세대
        int next;
        for(int i=1; i<=maxGeneration; i++){ //1세대 ~ max세대 까지
            for(int j=0; j<dirInfo.size(); j++){
                next = dirInfo.get(j);
                temp.addFirst((next+1) % 4);
            }
            dirInfo.addAll(temp);
            temp.clear();
        }

        int cur;
        int ny,nx;
        map[dy][dx] = 1;// 시작좌표
        for(int i=0; i<dirInfo.size(); i++){
            cur = dirInfo.get(i);
            nx = dx + getDir[cur][0];
            ny = dy + getDir[cur][1];
            if(ny<0 || ny>100 || nx<0 || nx > 100)
                continue;
            map[ny][nx] = 1;
            dx = nx;
            dy = ny;
        }

    }

    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        n = Integer.parseInt(br.readLine());
        map = new int[101][101];
        dragons = new int[n][4];
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<4; j++){
                    dragons[i][j] = Integer.parseInt(st.nextToken());
                }
            }

        //x,y 열,행
        for(int i=0; i<n; i++){
            makeDragon(dragons[i][0],dragons[i][1],dragons[i][2],dragons[i][3]);
        }

        int cnt=0;
        for(int i=0; i<100; i++){
            for(int j=0; j<100; j++){
                if(map[i][j]==1 && map[i+1][j]==1 && map[i][j+1]==1 &&map[i+1][j+1]==1) {
                    cnt++;
                }
            }
        }
        bw.write(cnt+"");
        bw.flush();
        bw.close();
    }
}
