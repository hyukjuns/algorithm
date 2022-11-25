package boj.Simulation;

import java.io.*;
import java.util.StringTokenizer;

public class Simulation_14499 {
    private static int n,m,x,y,k;
    private static int[][] graph = null;
    private static int[] dice = new int[7];
    private static int[] ndice = new int[7];
    private static int[] opcode = null;
    private static int[][] dir = {{0,1},{0,-1},{-1,0},{1,0}};//동 서 북 남 (x,y)

    public static void solve(){
        int dx,dy;
        for(int i=0; i<k; i++){
            dx = x + dir[opcode[i]-1][0];
            dy = y + dir[opcode[i]-1][1];
            if(dx < 0 || dx > n-1 || dy < 0 || dy > m-1) //바깥으로 이동하는 경우 다음 순서로
                continue;
            switch (opcode[i]){ //동,서 : 2,5유지, 북,남 : 3,4유지
                case 1: {//동
                    ndice[3] = dice[1];
                    ndice[6] = dice[3];
                    ndice[4] = dice[6];
                    ndice[1] = dice[4];
                    ndice[2] = dice[2];
                    ndice[5] = dice[5];
                    break;
                }
                case 2:{//서
                    ndice[4] = dice[1];
                    ndice[6] = dice[4];
                    ndice[3] = dice[6];
                    ndice[1] = dice[3];
                    ndice[2] = dice[2];
                    ndice[5] = dice[5];
                    break;
                }
                case 3:{//북
                    ndice[2] = dice[1];
                    ndice[6] = dice[2];
                    ndice[5] = dice[6];
                    ndice[1] = dice[5];
                    ndice[3] = dice[3];
                    ndice[4] = dice[4];
                    break;
                }
                case 4:{//남
                    ndice[5] = dice[1];
                    ndice[6] = dice[5];
                    ndice[2] = dice[6];
                    ndice[1] = dice[2];
                    ndice[3] = dice[3];
                    ndice[4] = dice[4];
                    break;
                }
            }

            if(graph[dx][dy] == 0){//맵이 0이면 주사위 -> 칸 으로 복사
                graph[dx][dy] = ndice[6];
            }
            else{ // 맵이 0이 아니면 칸 -> 주사위로 복사, 칸 -> 0
                ndice[6] = graph[dx][dy];
                graph[dx][dy] = 0;
            }

            System.out.println(ndice[1]);//상단 출력
            for(int d=0; d<6; d++){//주사위 업데이트
                dice[d+1] = ndice[d+1];
            }
            //현재 위치 업데이트
            x = dx;
            y = dy;
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        opcode = new int[k];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<k; i++){
            opcode [i] = Integer.parseInt(st.nextToken());
        }

        solve();
    }
}
