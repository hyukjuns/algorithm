package boj.dfs;

import java.io.*;
import java.util.StringTokenizer;

public class DFS_2573 {
    private static int n,m;
    private static int[][] map;
    private static int[][] tempMap;
    private static int[][] zeroCnt;
    private static boolean[][] visited;
    public static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}}; //동서남북

    public static void print(){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
    public static void copyArr(int[][] a, int[][] b){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                a[i][j] = b[i][j];
            }
        }
    }
    public static void afterYear(){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] > 0) {
                    int temp = map[i][j] - zeroCnt[i][j];
                    if(temp >= 0)
                        map[i][j] = temp;
                    else
                        map[i][j] = 0;
                }
            }
        }
    }
    public static void dfs(int y,int x, int idx){
        visited[y][x] = true;
        map[y][x] = idx;
        int nextY,nextX;
        for(int i=0; i<4; i++){
            nextY = y + dir[i][0];
            nextX = x + dir[i][1];
            if(nextY >= 0 && nextY < n && nextX >= 0 && nextX < m){
                if(map[nextY][nextX] == 0)
                    zeroCnt[y][x]++; //주변에 0인 지점 카운트
            }
        }
        for(int i=0; i<4; i++){
            nextY = y + dir[i][0];
            nextX = x + dir[i][1];
            if(nextY >= 0 && nextY < n && nextX >= 0 && nextX < m){
                if(map[nextY][nextX] != 0 && !visited[nextY][nextX]){
                    dfs(nextY,nextX,idx); //구역 정복
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        tempMap = new int[n][m];
        zeroCnt = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year=0;
        while(true) {
            copyArr(tempMap,map);//맵 원형보존
            int id = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] != 0 && !visited[i][j])
                        dfs(i, j, ++id); //구역정복
                }
            }
            //print();
            if(id >= 2){ //구역이 2개 이상일때
                bw.write(year+"");
                break;
            }
            else if(id == 0){ //구역이 나눠지지 않고 빙산이 전부 녹았을때
                bw.write("0");
                break;
            }
            copyArr(map,tempMap); //맵 복구
            afterYear(); // 1년경과
            year++; // 1년경과
            for (int i = 0; i < n; i++) { //visited,zeroCnt 초기화
                for (int j = 0; j < m; j++) {
                    visited[i][j] = false;
                    zeroCnt[i][j] = 0;
                }
            }
        }
        bw.flush();
        bw.close();
    }
}
