package samsungsw;

import java.awt.*;
import java.io.*;
import java.util.*;

public class Sw_17472 {
    static int n,m;
    static int[][] map;
    static boolean[][] visited;
    static int landId=0;
    static int sum=0;
    static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    static LinkedList<Bridge> blist = new LinkedList<>();

    static int getParent(int[] parent, int x){
        if(parent[x] == x)  return x;
        return parent[x] = getParent(parent,parent[x]);
    }

    static void unionParent(int[] parent, int a, int b){
        a = getParent(parent,a);
        b = getParent(parent,b);
        if(a < b)   parent[b] = a;
        else    parent[a] = b;
    }

    static boolean find(int[] parent, int a, int b){
        a = getParent(parent,a);
        b = getParent(parent,b);
        if(a == b)  return true;
        else    return false;
    }

    static void makeBridge(int startLand) {
        Queue<Point> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == startLand){
                    q.add(new Point(j,i));
                }
            }
        }

        while(!q.isEmpty()){
            Point temp = q.poll();
            for(int i=0; i<4; i++){
                int ny,nx;
                int dy = temp.y;
                int dx = temp.x;
                int distance=0;
                while(true){
                    ny = dy + dir[i][0];
                    nx = dx + dir[i][1];
                    if(ny>=n || ny<0 || nx>=m || nx<0 || map[ny][nx]==startLand)  break;
                    if(map[ny][nx] != 0 && map[ny][nx] != startLand){
                        if(distance<2){
                            break;
                        }
                        else{
                            blist.add(new Bridge(startLand,map[ny][nx],distance));
                            break;
                        }
                    }
                    distance++;
                    dy = ny;
                    dx = nx;
                }
            }
        }
    }

    static void masking(int id, int y, int x){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x,y));
        map[y][x] = id;
        visited[y][x] = true;

        int ny,nx;
        while(!q.isEmpty()){
            Point temp = q.poll();
            for(int i=0; i<4; i++){
                ny = temp.y + dir[i][0];
                nx = temp.x + dir[i][1];
                if(ny>=n || ny<0 || nx>=m || nx<0)  continue;
                if(!visited[ny][nx] && map[ny][nx]==1){
                    visited[ny][nx] = true;
                    map[ny][nx] = id;
                    q.add(new Point(nx,ny));
                }
            }
        }

    }
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //각 섬 마스킹
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j]==1 && !visited[i][j]){
                    masking(++landId,i,j);
                }
            }
        }
        //print();

        //지을수 있는 모든 다리 건설
        for(int i=1; i<=landId; i++){
            makeBridge(i);
        }

        //거리 기준 오름차순 정렬
        Collections.sort(blist, new Comparator<Bridge>() {
            @Override
            public int compare(Bridge o1, Bridge o2) {
                return o1.distance > o2.distance ? 1 : (o1.distance==o2.distance) ? 0 : -1;
            }
        });

        //사이클 테이블 set 생성
        int[] set = new int[landId+1];
        for(int i=1; i<=landId; i++){
            set[i] = i;
        }

        //거리의 합과 최소 간선 갯수 충족여부 확인(모든 섬을 이을수 있는지 여부)
        int cnt=0;
        for(int i=0; i<blist.size(); i++){
            //같은 부모를 가진 노드가 아니면 같은 부모로 합치기(노드 연결 즉, 연결되어잇지 않으면 다리길이 합하고 다리 건설)
            if(!find(set,blist.get(i).node[0], blist.get(i).node[1])){
                cnt++;
                sum += blist.get(i).distance;
                unionParent(set,blist.get(i).node[0],blist.get(i).node[1]);
            }
        }

        //최소 간선 갯수 = 노드갯수 - 1
        if(cnt< landId-1) {
            sum = -1;
        }
        bw.write(sum+"");
        bw.flush();
        bw.close();
    }

    public static void print(){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
}

//다리 객체
class Bridge{
    int[] node = new int[2];
    int distance;
    public Bridge(int a, int b ,int distance){
        this.node[0] = a;
        this.node[1] = b;
        this.distance = distance;
    }
}
