package boj.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS_13460 {
    public static int n,m;
    public static char[][] graph = null;
    public static boolean[][][][] visited = null;
    public static int[][] dir = {{0,-1},{0,1},{-1,0},{1,0}};

    public static void bfs() {
        Queue<DOT4> q = new LinkedList<DOT4>();
        int ry=0,rx=0,by=0,bx=0;
        int nry,nrx, nby,nbx;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(graph[i][j] == 'R'){
                    ry = i;
                    rx = j;
                    graph[ry][rx] = '.';
                }
                else if(graph[i][j] == 'B'){
                    by = i;
                    bx = j;
                    graph[by][bx]= '.';
                }
            }
        }
        q.add(new DOT4(ry,rx,by,bx));
        visited[ry][rx][by][bx] = true;

        int cnt=0;
        while(!q.isEmpty()) {
            int qlen = q.size();
            while(qlen-- != 0){ //큐에 담긴 요소가 모두 소진되면 1뢰로 생각
                DOT4 cur = q.poll();
                if(graph[cur.ry][cur.rx] == 'O' && graph[cur.by][cur.bx] != 'O'){
                    System.out.println(cnt);
                    return;
                }
                for(int i=0; i<4; i++){ //동서남북
                    ry = cur.ry;
                    rx = cur.rx;
                    by = cur.by;
                    bx = cur.bx;

                    while(true){ //빨간구슬
                        nry = ry + dir[i][0];
                        nrx = rx + dir[i][1];
                        if(graph[nry][nrx] == '#' || graph[ry][rx] == 'O')
                            break;
                        ry = nry;
                        rx = nrx;
                    }

                    while(true){ //파란구슬
                        nby = by + dir[i][0];
                        nbx = bx + dir[i][1];
                        if(graph[nby][nbx] == '#' || graph[by][bx] == 'O')
                            break;
                        by = nby;
                        bx = nbx;
                    }

                    if(ry==by && rx==bx){
                        if(graph[by][bx] == 'O')
                            continue;
                        if(Math.abs(ry-cur.ry)+Math.abs(rx-cur.rx) > Math.abs(by-cur.by)+Math.abs(bx-cur.bx)){
                            ry -= dir[i][0];
                            rx -= dir[i][1];
                        }
                        else{
                            by -= dir[i][0];
                            bx -= dir[i][1];
                        }
                    }

                    if(!visited[ry][rx][by][bx]){
                        visited[ry][rx][by][bx] = true;
                        q.add(new DOT4(ry,rx,by,bx));
                    }

                }
            }
            if(cnt==10) {
                System.out.println(-1);
                return;
            }
            cnt++;
        }
        System.out.println(-1);
        return;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new char[n][m];
        visited = new boolean[n][m][n][m];
        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<m; j++){
                graph[i][j] = str.charAt(j);
            }
        }
        bfs();
    }
}
class DOT4{
    int ry;
    int rx;
    int by;
    int bx;
    public DOT4(int ry, int rx, int by, int bx) {
        this.ry = ry;
        this.rx = rx;
        this.by = by;
        this.bx = bx;
    }
}

