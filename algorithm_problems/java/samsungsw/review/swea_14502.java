package samsungsw.review;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.awt.Point;
import java.util.Queue;
public class swea_14502 {
    static int n,m;
    static int[][] map;
    static int[][] tempMap;
    static int ans=Integer.MIN_VALUE;
    static int[][] dir = {{0,1},{-1,0},{0,-1},{1,0}};
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        tempMap = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j]==0) {
                    //backtracking
                    map[i][j]=1;
                    dfs(1);
                    map[i][j]=0;
                }
            }
        }
        bw.write(ans+"");
        bw.flush();
        bw.close();
    }
    public static boolean isValid(int dy, int dx){
        return (dy<n && dy >=0) && (dx<m && dx>=0) ? true:false;
    }
    public static void copyArr(int[][] a, int[][] b){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                b[i][j] = a[i][j];
            }
        }
    }
    public static void dfs(int cnt){
        if(cnt==3){
            copyArr(map,tempMap);
            ans = Math.max(ans,spreadVirus(tempMap));
            return;
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j]==0){
                    //backtracking
                    map[i][j]=1;
                    dfs(cnt+1);
                    map[i][j]=0;
                }
            }
        }
    }
    public static int spreadVirus(int[][] tempMap){
        Queue<Point> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(tempMap[i][j]==2){
                    q.add(new Point(j,i));
                }
            }
        }
        int ny,nx;
        while(!q.isEmpty()){
            Point cur = q.poll();
            for(int i=0; i<4; i++){
                ny = cur.y + dir[i][0];
                nx = cur.x + dir[i][1];
                if(isValid(ny,nx) && tempMap[ny][nx]==0){
                    tempMap[ny][nx] = 2;
                    q.add(new Point(nx,ny));
                }
            }
        }
        return check(tempMap);
    }
    public static int check(int[][] target){
        int cnt=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(target[i][j]==0) cnt++;
            }
        }
        return cnt;
    }
    public static void print(int[][] t){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(t[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
