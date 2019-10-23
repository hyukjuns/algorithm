package boj.samsung_a;  // 17135 캐슬 디펜스 백트래킹, 시뮬레이션

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class Casle_defense {
    private static int n,m,d;
    private static int[][] map = null;
    private static int[][] tempMap = null;
    private static ArrayList<DOT> enemy= new ArrayList<>();//적 위치 수집

    public static int bfs() {
        ArrayList<DOT> tempEnemy = new ArrayList<>();
        for(int i=0; i<enemy.size(); i++){
            tempEnemy.add(enemy.get(i));
        }
        int cnt=0;
        int[] archer = new int[3];
        int a=0;
        for (int i = 0; i < m; i++) {
            if (tempMap[n][i] == 2)
                archer[a++] = i;//궁수는 n행 고정, 열 만 바뀜;
        }

        while(!tempEnemy.isEmpty()) {
            //타겟선정
            ArrayList<DOT> target = new ArrayList<>();
            for (int i = 0; i < archer.length; i++) {//궁수는 동시에 공격
                int x = archer[i];//궁수 위치 : n행 x 열
                DOT tempTarget = tempEnemy.get(0);
                int dist = Math.abs(n - tempTarget.y) + Math.abs(x - tempTarget.x);
                int enemyX = tempTarget.x;
                DOT idx = new DOT(tempTarget.y,tempTarget.x);//초기화
                for(int j=1; j<tempEnemy.size(); j++){ //사정거리 안에 있는 적 수집;
                    tempTarget = tempEnemy.get(j);
                    int tempDist = Math.abs(n - tempTarget.y) + Math.abs(x - tempTarget.x);
                    if(dist > tempDist){
                        enemyX = tempTarget.x;
                        dist = tempDist;
                        idx = new DOT(tempTarget.y,tempTarget.x);
                    }
                    else if(dist == tempDist && enemyX > tempTarget.x){ //거리가 같다면 가장 왼쪽
                        enemyX = tempTarget.x;
                        idx = new DOT(tempTarget.y,tempTarget.x);
                    }
                }
                if(dist <= d){
                    target.add(idx);
                }
            }

            //동시공격, 적 제거 카운트
            for(int i=0; i<target.size(); i++){
                for(int j=0; j<tempEnemy.size(); j++) {
                    if (target.get(i).y == tempEnemy.get(j).y && target.get(i).x == tempEnemy.get(j).x) {
                        tempEnemy.remove(j);
                        tempMap[target.get(i).y][target.get(i).x] = 0;
                        cnt++;
                    }
                }
            }
            if(tempEnemy.isEmpty())
                break;
            //한칸아래로
            mapDown();
            tempEnemy.clear();
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(tempMap[i][j]==1)
                        tempEnemy.add(new DOT(i,j));
                }
            }

        }
        return cnt;
    }
    public static void mapCopy(){
        for(int i=0; i<=n; i++){
            for(int j=0; j<m; j++){
                tempMap[i][j] = map[i][j];
            }
        }
    }
    public static void mapDown(){
        for(int i=n-2; i>=0; i--){
            for(int j=0; j<m; j++){
                tempMap[i+1][j] = tempMap[i][j];
            }
        }
        for(int i=0; i<m; i++){
            tempMap[0][i] = 0;
        }
    }
    public static int solution(){
        int res1=0;
        int max=0;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<m; j++) {
                for (int k = j + 1; k < m; k++) {
                    map[n][i] = 2;//2 is arrower
                    map[n][j] = 2;//2 is arrower
                    map[n][k] = 2;//2 is arrower
                    mapCopy();
                    res1 = bfs();
                    if(max<res1)
                        max = res1;
                    map[n][i] = 0;
                    map[n][j] = 0;
                    map[n][k] = 0;
                }
            }
        }
        return max;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        map = new int[n+1][m];
        tempMap = new int[n+1][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j]==1)
                    enemy.add(new DOT(i,j));
            }
        }
        int res = solution();
        bw.write(res+"");
        bw.flush();
        bw.close();
    }
}
class DOT{
    int y;
    int x;
    public DOT(int y, int x){
        this.y = y;
        this.x = x;
    }
}