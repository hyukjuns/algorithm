package samsungsw.review;

import java.io.*;
import java.util.StringTokenizer;

public class swea_12100 {
    static int ans=Integer.MIN_VALUE;
    static int n;
    static int[][] map;
    static boolean[][] merged;
    static int[][] dir = {{0,1},{-1,0},{0,-1},{1,0}};
    public static boolean isValid(int dy, int dx){
        return (dy>=0 && dy<n) && (dx>=0 && dx<n) ? true:false;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(map,0);
        bw.write(ans+"");
        bw.flush();
        bw.close();

    }
    public static void copyArr(int[][] a, int[][] b){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                b[i][j] = a[i][j];
            }
        }
    }
    public static int check(int[][] checkMap){
        int ret=Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                ret = Math.max(ret,checkMap[i][j]);
            }
        }
        return ret;
    }
    // prevMap is previous tempMap
    public static void dfs(int[][] prevMap,int cnt){
        if(cnt==5){
            ans = Math.max(ans,check(prevMap));
            return;
        }
        int[][] tempMap = new int[n][n];
        for(int i=0; i<4; i++){
            copyArr(prevMap,tempMap); //copy original to temp
            move(i, tempMap); //use temp
            dfs(tempMap, cnt+1); //send updated tempMap
            // dfs end, go to copyArr and move
        }

    }

    public static void move(int d,int[][] tempMap){
        // each block: 1 move, 1 merge
        merged = new boolean[n][n];
        int[][] nextMap = new int[n][n];
        if(d==0){
            for(int i=n-1; i>=0; i--){
                int dy,dx;
                int ny,nx;
                for(int j=0; j<n; j++){
                    dy = j;
                    dx = i;
                    while(true) {
                        ny = dy + dir[d][0];
                        nx = dx + dir[d][1];
                        if (!isValid(ny,nx)) {
                            nextMap[dy][dx] = tempMap[j][i];
                            break;
                        }
                        if(nextMap[ny][nx] != 0){
                            if(nextMap[ny][nx] == tempMap[j][i] && !merged[ny][nx]){
                                nextMap[ny][nx] = tempMap[j][i]+tempMap[j][i];
                                merged[ny][nx] = true;
                                break;
                            }else{
                                nextMap[dy][dx] = tempMap[j][i];
                                break;
                            }
                        }
                        dy = ny;
                        dx = nx;
                    }
                }
            }
        }else if(d==1){
            for(int i=0; i<n; i++){
                int dy,dx;
                int ny,nx;
                for(int j=0; j<n; j++){
                    dy = i;
                    dx = j;
                    while(true) {
                        ny = dy + dir[d][0];
                        nx = dx + dir[d][1];
                        if (!isValid(ny,nx)) {
                            nextMap[dy][dx] = tempMap[i][j];
                            break;
                        }
                        if(nextMap[ny][nx] != 0){
                            if(nextMap[ny][nx] == tempMap[i][j] && !merged[ny][nx]){
                                nextMap[ny][nx] = tempMap[i][j]+tempMap[i][j];
                                merged[ny][nx]=true;
                                break;
                            }else{
                                nextMap[dy][dx] = tempMap[i][j];
                                break;
                            }
                        }
                        dy = ny;
                        dx = nx;
                    }
                }
            }
        }else if(d==2){
            for(int i=0; i<n; i++){
                int dy,dx;
                int ny,nx;
                for(int j=0; j<n; j++){
                    dy = j;
                    dx = i;
                    while(true) {
                        ny = dy + dir[d][0];
                        nx = dx + dir[d][1];
                        if (!isValid(ny,nx)) {
                            nextMap[dy][dx] = tempMap[j][i];
                            break;
                        }
                        if(nextMap[ny][nx] != 0){
                            if(nextMap[ny][nx] == tempMap[j][i] && !merged[ny][nx]){
                                nextMap[ny][nx] = tempMap[j][i]+tempMap[j][i];
                                merged[ny][nx]=true;
                                break;
                            }else{
                                nextMap[dy][dx] = tempMap[j][i];
                                break;
                            }
                        }
                        dy = ny;
                        dx = nx;
                    }
                }
            }
        }else{
            for(int i=n-1; i>=0; i--){
                int dy,dx;
                int ny,nx;
                for(int j=0; j<n; j++){
                    dy = i;
                    dx = j;
                    while(true) {
                        ny = dy + dir[d][0];
                        nx = dx + dir[d][1];
                        if (!isValid(ny,nx)) {
                            nextMap[dy][dx] = tempMap[i][j];
                            break;
                        }
                        if(nextMap[ny][nx] != 0){
                            if(nextMap[ny][nx] == tempMap[i][j] && !merged[ny][nx]){
                                nextMap[ny][nx] = tempMap[i][j]+tempMap[i][j];
                                merged[ny][nx]=true;
                                break;
                            }else{
                                nextMap[dy][dx] = tempMap[i][j];
                                break;
                            }
                        }
                        dy = ny;
                        dx = nx;
                    }
                }
            }
        }
        // copy nextMap to tempMap, tempMap update
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                tempMap[i][j] = nextMap[i][j];
            }
        }
    }

}
