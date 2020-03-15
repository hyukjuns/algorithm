package samsungsw;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.awt.Point;

public class Sw_17142 {
    static int idx=0;
    static int n,m;
    static char[][] map;
    static boolean[][] virused;
    static LinkedList<Point> virusSite = new LinkedList<>();
    static boolean[] visited;
    static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    static int ans=Integer.MAX_VALUE;

    static void print(char[][] map){
        System.out.println(++idx);
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();

    }
    static void copyArr(char[][] target, char[][] origin){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                target[i][j] = origin[i][j];
            }
        }
    }
    static void spreadVirus(char[][] currentMap){
        Queue<DOT3> q = new LinkedList<>();
        virused = new boolean[n][n];
        for(int i=0; i<virusSite.size(); i++){// 비활성
            Point temp = virusSite.get(i);
            if(!visited[i] && currentMap[temp.y][temp.x]=='2'){
                currentMap[temp.y][temp.x] = '*';
            }
        }
        for(int i=0; i<virusSite.size(); i++){
            Point temp = virusSite.get(i);
            if(currentMap[temp.y][temp.x] == '!'){
                currentMap[temp.y][temp.x] = '0';
                q.add(new DOT3(temp.y,temp.x,0));
            }
        }

        int ny,nx;
        while(!q.isEmpty()){
            DOT3 cur = q.poll();
            for(int i=0; i<4; i++){
                ny = cur.y + dir[i][0];
                nx = cur.x + dir[i][1];
                Point temp = new Point(nx,ny);
                if(ny>=n || ny<0 || nx>=n || nx<0) continue;
                if(currentMap[ny][nx]=='0' && !virusSite.contains(temp) && !virused[ny][nx]){
                    virused[ny][nx]= true;
                    currentMap[ny][nx] = (char)(cur.cnt+1+'0');
                    q.add(new DOT3(ny,nx,cur.cnt+1));
                }
                else if(currentMap[ny][nx]=='*' && !virused[ny][nx]){
                     virused[ny][nx] = true;
                    //currentMap[ny][nx] = (char)(cur.cnt+1+'0');
                    q.add(new DOT3(ny,nx,cur.cnt+1));
                }
            }
        }

    }
    static void makeMap(char[][] prev, int cnt, int idx){
        char[][] currentMap = new char[n][n];
        copyArr(currentMap,prev);
        if(cnt==m){
            spreadVirus(currentMap);
            //print(currentMap);
            int maxTime=0;
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    Point temp = new Point(j,i);
                    if(currentMap[i][j]=='0' && !virusSite.contains(temp)) {
                        return;
                    }
                    else{
                        maxTime = Math.max(maxTime,currentMap[i][j]-'0');
                    }
                }
            }
            ans = Math.min(ans,maxTime);
            return;
        }
        for(int i=idx; i<virusSite.size(); i++){//활성
            Point temp = virusSite.get(i);
            if(!visited[i]){
                visited[i] = true;
                currentMap[temp.y][temp.x] = '!';
                makeMap(currentMap,cnt+1, i+1);
                visited[i] = false;
                currentMap[temp.y][temp.x] = '2';
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][n];
        for(int i=0; i<n; i++){
            String str = br.readLine().replace(" ","");
            for(int j=0; j<n; j++){
                map[i][j] = str.charAt(j);
                if(map[i][j]=='2'){
                    virusSite.add(new Point(j,i));
                }
                else if(map[i][j]=='1'){
                    map[i][j] = '-';
                }
            }
        }
        visited = new boolean[virusSite.size()];
        makeMap(map,0,0);
        if(ans==Integer.MAX_VALUE)
            ans=-1;
        bw.write(ans+"");
        bw.flush();
        bw.close();

    }
}
class DOT3{
    int y;
    int x;
    int cnt;
    public DOT3(int y, int x, int cnt){
        this.y=y;
        this.x=x;
        this.cnt=cnt;
    }
}