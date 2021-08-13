package samsungsw;

import java.io.*;
import java.util.*;

public class Sw_16236 {
    static int n;
    static int jaws=2;
    static int tank=0;
    static int time=0;
    static int[][] map;
    static boolean[][] visited;
    static LinkedList<Spot> possible;
    static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};

    static void bfs(int y, int x){
        Queue<Spot> temp = new LinkedList<>();
        temp.add(new Spot(y,x,0));

        int ny,nx;
        while(!temp.isEmpty()){
            Spot cur = temp.poll();
            for(int i=0; i<4; i++){//아기 상어는 1초에 상하좌우로 인접한 한 칸씩 이동한다.
                ny = cur.y + dir[i][0];
                nx = cur.x + dir[i][1];
                if(ny>=n || ny<0 || nx>=n || nx<0)  continue;
                //아기 상어는 자신의 크기보다 큰 물고기가 있는 칸은 지나갈 수 없고.
                //나머지 칸은 모두 지나갈 수 있다.
                if(map[ny][nx] <= jaws && !visited[ny][nx]){ //일단 이동 가능
                    //아기 상어는 자신의 크기보다 작은 물고기만 먹을 수 있다.
                    if(map[ny][nx] != 0 && map[ny][nx] < jaws){
                        //거리는 아기 상어가 있는 칸에서 물고기가 있는 칸으로 이동할 때, 지나야하는 칸의 개수의 최솟값이다.
                        possible.add(new Spot(ny,nx,cur.cnt+1)); //먹을 수 잇는곳
                    }
                    visited[ny][nx] = true;
                    temp.add(new Spot(ny,nx,cur.cnt+1)); //이동가능한곳
                }
            }
        }

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=null;
        Spot target;
        Spot jawsIdx = new Spot(0,0,0);

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==9){
                    map[i][j]=0;
                    jawsIdx.y = i;
                    jawsIdx.x = j;
                }
            }
        }
        while(true){
            possible = new LinkedList<>();
            visited = new boolean[n][n];
            bfs(jawsIdx.y,jawsIdx.x);

            //더 이상 먹을 수 있는 물고기가 공간에 없다면 아기 상어는 엄마 상어에게 도움을 요청한다.
            if(possible.isEmpty()) {
                break;
            }
            //먹을 수 있는 물고기가 1마리보다 많다면, 거리가 가장 가까운 물고기를 먹으러 간다.
            else if(possible.size()>1){
                Collections.sort(possible, new Comparator<Spot>() {
                    @Override
                    public int compare(Spot o1, Spot o2) {
                        if(o1.cnt > o2.cnt){
                            return 1;
                        }
                        else if(o1.cnt==o2.cnt){
                            //거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기
                            if(o1.y > o2.y) {
                                return 1;
                            }
                            //그러한 물고기가 여러마리라면, 가장 왼쪽에 있는 물고기를 먹는다.
                            else if(o1.y == o2.y) {
                                if(o1.x > o2.x)
                                    return 1;
                            }

                        }
                        return -1;

                    }
                });
            }
            //먹을 수 있는 물고기가 1마리라면, 그 물고기를 먹으러 간다.
            target = possible.get(0);
            tank += 1;
            //아기 상어는 자신의 크기와 같은 수의 물고기를 먹을 때 마다 크기가 1 증가한다
            if(tank >= jaws){
                jaws+=1;
                tank=0;
            }
            time += target.cnt;
            map[target.y][target.x] = 0;
            jawsIdx.y = target.y;
            jawsIdx.x = target.x;
        }

        bw.write(time+"");
        bw.flush();
        bw.close();

    }
}
class Spot {
    int y;
    int x;
    int cnt;
    public Spot(int y,int x, int cnt){
        this.y = y;
        this.x = x;
        this.cnt = cnt;
    }
}
