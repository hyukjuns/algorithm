package boj.dfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS_2146 {
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    static int ans=Integer.MAX_VALUE;
    public static boolean isInMao(int dy, int dx){
        return (dy>=0 && dy<n) && (dx>=0 && dx<n) ? true:false;
    }
    public static void masking(int y, int x, int land){
        map[y][x] = land;
        for(int i=0; i<4; i++){
            int ny = y + dir[i][0];
            int nx = x + dir[i][1];
            if(isInMao(ny,nx)) {
                if(map[ny][nx] != 0 && !visited[ny][nx]){
                    visited[ny][nx] = true;
                    masking(ny,nx,land);
                }
            }
        }
    }

    public static void bfs(int landIdx){
        Queue<LandInfo> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == landIdx){ //해당 섬의 육지 위치 모두 담기
                    q.offer(new LandInfo(i,j,0));
                }
            }
        }

        while(!q.isEmpty()){
            LandInfo cur = q.poll();
            for(int i=0; i<4; i++){
                int ny = cur.y + dir[i][0];
                int nx = cur.x + dir[i][1];
                if(isInMao(ny,nx)){
                    if(map[ny][nx] == 0 && !visited[ny][nx]){ //바다, 처음 방문 -> 큐에 담는다
                        visited[ny][nx] = true;
                        q.offer(new LandInfo(ny,nx,cur.cnt+1));// 다리 건설
                    }
                    else if(map[ny][nx] != 0 && !visited[ny][nx]){
                        if(map[ny][nx] != landIdx){ //다른 섬에 도달햇으면
                            ans = ans > cur.cnt ? cur.cnt : ans; //최소값 구하기
                        }
                    }
                }
            }
        }

    }


    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //DFS적으로 섬 이름 라벨링
        int land=1;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    visited[i][j] = true;
                    masking(i,j,land++);
                }
            }
        }

        //초기화
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
               visited[i][j] = false;
            }
        }
        for(int i=1; i<land; i++){
            bfs(i);
            //초기화
            for(int j=0; j<n; j++){
                for(int k=0; k<n; k++){
                    visited[j][k] = false;
                }
            }
        }
        bw.write(ans+"");
        bw.flush();
        bw.close();
    }
}
class LandInfo{
    int y;
    int x;
    int cnt;
    public LandInfo(int y, int x, int cnt){
        this.y = y;
        this.x = x;
        this.cnt = cnt;
    }
}

