package samsungsw;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Sw_15683 {
    static int n,m;
    static int[][] map;
    static int ans = Integer.MAX_VALUE;
    static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    static LinkedList<CCTV> cctvs = new LinkedList<>();

    public static boolean isValid(int dy, int dx){
        return (dy>=0 && dy<n) && (dx>=0 && dx <m) ? true : false;
    }
    public static void solve(int cnt, int[][] prev){
        int[][] copiedMap = new int[n][m];
        if(cnt == cctvs.size()){
            int xbox=0;
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    //System.out.print(prev[i][j]+" ");
                    if(prev[i][j] == 0)
                        xbox++;
                }
                //System.out.println();
            }
            if(ans > xbox)
                ans = xbox;
        }
        else {
            int type = cctvs.get(cnt).type;
            int curY = cctvs.get(cnt).y;
            int curX = cctvs.get(cnt).x;
            switch (type) {
                case 1: {
                    for (int i = 0; i < 4; i++) {
                        for (int k = 0; k < n; k++) {
                            copiedMap[k] = Arrays.copyOf(prev[k], m);
                        }
                        detect(i, curY, curX, copiedMap);
                        solve(cnt + 1, copiedMap);
                    }
                }
                break;
                case 2:{
                    for (int i = 0; i < 2; i++) {
                        for (int k = 0; k < n; k++) {
                            copiedMap[k] = Arrays.copyOf(prev[k], m);
                        }
                        detect(i, curY, curX, copiedMap);
                        detect(i+2, curY, curX, copiedMap);
                        solve(cnt + 1, copiedMap);
                    }
                }
                break;
                case 3:{
                    for (int i = 0; i < 4; i++) {
                        for (int k = 0; k < n; k++) {
                            copiedMap[k] = Arrays.copyOf(prev[k], m);
                        }
                        detect(i, curY, curX, copiedMap);
                        detect((i+1) % 4, curY, curX, copiedMap);
                        solve(cnt + 1, copiedMap);
                    }
                }
                break;
                case 4:{
                    for (int i = 0; i < 4; i++) {
                        for (int k = 0; k < n; k++) {
                            copiedMap[k] = Arrays.copyOf(prev[k], m);
                        }
                        detect(i, curY, curX, copiedMap);
                        detect((i+1) % 4, curY, curX, copiedMap);
                        detect((i+2) % 4, curY, curX, copiedMap);
                        solve(cnt + 1, copiedMap);
                    }
                }
                break;
                case 5:{
                    for (int k = 0; k < n; k++) {
                        copiedMap[k] = Arrays.copyOf(prev[k], m);
                    }
                    detect(0, curY, curX, copiedMap);
                    detect(1, curY, curX, copiedMap);
                    detect(2, curY, curX, copiedMap);
                    detect(3, curY, curX, copiedMap);
                    solve(cnt + 1, copiedMap);
                }
                break;
            }
        }
    }
    public static void detect(int d, int curY, int curX, int[][] copiedMap){
        int ny,nx;
        while (true){
            ny = curY + dir[d][0];
            nx = curX + dir[d][1];
            if(!isValid(ny,nx) || copiedMap[ny][nx] == 6)
                break;
            if(copiedMap[ny][nx]>=1 && copiedMap[ny][nx] <= 5) {
                curY = ny;
                curX = nx;
                continue;
            }
            copiedMap[ny][nx] = 7;
            curY = ny;
            curX = nx;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] >= 1 && map[i][j] <= 5)
                    cctvs.offer(new CCTV(i,j,map[i][j]));
            }
        }
        solve(0,map);
        bw.write(ans+"");
        bw.flush();
        bw.close();
    }
}
class CCTV{
    int y;
    int x;
    int type;
    public CCTV(int y, int x, int type){
        this.y = y;
        this.x = x;
        this.type = type;
    }
}
