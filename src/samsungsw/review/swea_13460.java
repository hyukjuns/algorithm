package samsungsw.review;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_13460 {
    static int n,m;
    static char[][] map;
    static boolean[][][][] visited; //merge red's y,x and blue's y,x point
    static int[][] dir = {{0,1},{-1,0},{0,-1},{1,0}};
    static int ans;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited  = new boolean[n][m][n][m];
        for(int i=0; i<n; i++){
            String temp=br.readLine();
            for(int j=0; j<m; j++){
                map[i][j] = temp.charAt(j);
            }
        }
        bfs();
        bw.write(ans+"");
        bw.flush();
        bw.close();

    }
    public static void bfs(){
        Queue<Index> q = new LinkedList<>();
        int ry=0;
        int rx=0;
        int by=0;
        int bx=0;
        // check red, blue point and replace 'R','B' to '.'
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == 'R'){
                    ry = i;
                    rx = j;
                    map[i][j] = '.';
                }else if(map[i][j] == 'B'){
                    by = i;
                    bx = j;
                    map[i][j] = '.';
                }
            }
        }
        q.add(new Index(ry,rx,by,bx,0));
        while(!q.isEmpty()){
            Index cur = q.poll();
            //check count over 10
            if(cur.cnt>10){
                ans = -1;
                return;
            }
            //check if red in the hole
            if(map[cur.ry][cur.rx]=='O' && map[cur.by][cur.bx]!='O'){
                ans = cur.cnt;
                return;
            }
            // challenge 4 direct
            for(int i=0; i<4; i++){
                int dry = cur.ry;
                int drx = cur.rx;
                int dby = cur.by;
                int dbx = cur.bx;
                int nry,nrx,nby,nbx;
                //red
                while(true){
                    nry = dir[i][0] + dry;
                    nrx = dir[i][1] + drx;
                    if(map[nry][nrx] == '#' || map[dry][drx]== 'O')    break;
                    dry = nry;
                    drx = nrx;
                }
                //blue
                while(true){
                    nby = dir[i][0] + dby;
                    nbx = dir[i][1] + dbx;
                    if(map[nby][nbx] == '#' || map[dby][dbx]== 'O')    break;
                    dby = nby;
                    dbx = nbx;
                }
                //check if same point and if blue in the hole
                if(dry == dby && drx == dbx){
                    if(map[dby][dbx]=='O')  continue; //if blue in the hole, go to another challenge
                    int redLength = Math.abs(dry-cur.ry)+Math.abs(drx-cur.rx);
                    int blueLength = Math.abs(dby-cur.by)+Math.abs(dbx-cur.bx);
                    if(redLength > blueLength){
                        dry -= dir[i][0];
                        drx -= dir[i][1];
                    }else{
                        dby -= dir[i][0];
                        dbx -= dir[i][1];
                    }
                }
                //check visited point
                if(!visited[dry][drx][dby][dbx]){
                    q.add(new Index(dry,drx,dby,dbx,cur.cnt+1));
                    visited[dry][drx][dby][dbx]=true;
                }
            }
        }
        //here is impossible
        ans=-1;
    }
}
// red, blue index and count
class Index{
    int ry;
    int rx;
    int by;
    int bx;
    int cnt;
    public Index(int ry,int rx, int by,int bx, int cnt){
        this.ry=ry;
        this.rx=rx;
        this.by=by;
        this.bx=bx;
        this.cnt=cnt;
    }
}
