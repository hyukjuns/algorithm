package samsungsw;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Sw_17471 {
    static int n;
    static int[]  population;
    static boolean[] used;
    static int[][] map;
    static boolean[] visited;
    static ArrayList<Integer> gruopA;
    static ArrayList<Integer> gruopB;
    static LinkedList<Integer> city = new LinkedList<>();
    static int ans=Integer.MAX_VALUE;

    static void isConnected(int v, ArrayList<Integer> list){
        visited[v] = true;
        for(int i=1; i<=n; i++){
            if(map[v][i]==1 && !visited[i] && list.contains(i)){
                isConnected(i,list);
            }
        }
    }

    static void calculPopul(){
        gruopA = new ArrayList<>();
        gruopB = new ArrayList<>();
        for(int i=0; i<city.size(); i++){
            gruopA.add(city.get(i));
        }
        for(int i=1; i<=n; i++){
            if(!gruopA.contains(i)){
                gruopB.add(i);
            }
        }
        visited = new boolean[n+1];
        isConnected(gruopA.get(0),gruopA);
        for(int i=0; i<gruopA.size(); i++){
            if(!visited[gruopA.get(i)]){
                return;
            }
        }
        visited = new boolean[n+1];
        isConnected(gruopB.get(0),gruopB);
        for(int i=0; i<gruopB.size(); i++){
            if(!visited[gruopB.get(i)]){
                return;
            }
        }

        int sum1=0, sum2=0;
        for(int i=0; i<gruopA.size(); i++){
            sum1 += population[gruopA.get(i)];
        }
        for(int i=0; i<gruopB.size(); i++){
            sum2 += population[gruopB.get(i)];
        }
        ans = Math.min(ans, Math.abs(sum1-sum2));

    }
    static void makeGroup(int max, int cnt, int idx){
        if(cnt==max){
            calculPopul();
            //System.out.println(city);
            return;
        }
        for(int i=idx; i<=n; i++){
            if(!used[i]){
                used[i] = true;
                city.add(i);
                makeGroup(max,cnt+1,i+1);
                used[i] = false;
                city.pollLast();
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        population = new int[n + 1];
        used = new boolean[n + 1];
        map = new int[n + 1][n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            population[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num; j++) {

                int target = Integer.parseInt(st.nextToken());
                map[i][target] = 1;
            }
        }

        if (n == 2){
            ans = Math.min(ans, Math.abs(population[1] - population[2]));
            bw.write(ans+"");
            bw.flush();
            bw.close();
            return;
        }
        for(int i=1; i<=n/2; i++){
            makeGroup(i,0,1);
        }
        if(ans>=Integer.MAX_VALUE)
            ans=-1;
        bw.write(ans+"");
        bw.flush();
        bw.close();
    }
}
