package boj.bruteforce;

import java.io.*;
import java.util.*;

public class Brute_15686 {
    static int n,m;
    static int[][] map;
    static LinkedList<Info> chickens = new LinkedList<>();
    static LinkedList<Info> houses = new LinkedList<>();
    static LinkedList<Info> candiChickens = new LinkedList<>();
    static int sum=0;
    static int ans=Integer.MAX_VALUE;

    public static void getDistance(){
        int[] dist = new int[candiChickens.size()];
        //치킨 거리는 집과 가장 가까운 치킨집 사이의 거리이다.
        // 즉, 치킨 거리는 집을 기준으로 정해지며, 각각의 집은 치킨 거리를 가지고 있다.
        for(int i=0; i<houses.size(); i++){
            Info house = houses.get(i);
            for(int j=0; j<candiChickens.size(); j++){
                Info chicken = candiChickens.get(j);
                dist[j] = Math.abs(house.y-chicken.y) + Math.abs(house.x-chicken.x);
            }
            Arrays.sort(dist);//오름차순정렬
            sum += dist[0];//도시의 치킨 거리는 모든 집의 치킨 거리의 합이다.
        }
    }
    public static void dfs(int cnt, int max,int idx){
        if(cnt==max) {
            sum=0;
            getDistance();
            ans = Math.min(ans,sum);//도시의 치킨 거리의 최솟값
            return;
        }
        for(int i=idx; i<chickens.size(); i++){//백트래킹으로 완전탐색
            Info cur = chickens.get(i);
            candiChickens.add(new Info(cur.y,cur.x));
            dfs(cnt+1,max,i+1);
            candiChickens.removeLast();
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    chickens.add(new Info(i, j));
                }
                else if(map[i][j] == 1)
                    houses.add(new Info(i,j));
            }
        }
        for(int i=1; i<=m ;i++){
            dfs(0,i,0);
        }
        bw.write(ans+"");
        bw.flush();
        bw.close();
    }
}
class Info{
    int y;
    int x;
    public Info(int y, int x){
        this.y = y;
        this.x = x;
    }
}

