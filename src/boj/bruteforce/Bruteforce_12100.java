package boj.bruteforce;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bruteforce_12100 {
    static int n;
    static int[][] map;
    static int maxCnt=0;
    public static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}}; //상하좌우

    public static void copyArr(int[][] a, int[][] b){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                a[i][j] = b[i][j];
            }
        }
    }
    public static void move(int d){
        Queue<Integer> q = new LinkedList<>();

        switch (d){
            case 0://up
                for(int i=0; i<n; i++){//col
                    for(int j=0; j<n; j++){//row
                        if(map[j][i] != 0)
                            q.offer(map[j][i]); // i열의 j행마다 큐에 담는다
                        map[j][i] = 0;
                    }
                    int idx=0; //row
                    while(!q.isEmpty()){
                        int num = q.poll();
                        if(map[idx][i] == 0)
                            map[idx][i] = num;
                        else if(map[idx][i] == num) {
                            map[idx][i] *= 2;
                            idx++;
                        }
                        else{
                            idx++;
                            map[idx][i] = num;
                        }
                    }
                }
                break;
            case 1://down
                for(int i=0; i<n; i++){//col
                    for(int j=n-1; j>=0; j--){//row
                        if(map[j][i] != 0)
                            q.offer(map[j][i]);
                        map[j][i] = 0;
                    }
                    int idx=n-1;//row
                    while(!q.isEmpty()){
                        int num = q.poll();
                        if(map[idx][i] == 0)
                            map[idx][i] = num;
                        else if(map[idx][i] == num){
                            map[idx][i] *= 2;
                            idx--;
                        }
                        else{
                            idx--;
                            map[idx][i] = num;
                        }
                    }
                }
                break;
            case 2://left
                for(int i=0; i<n; i++){//row
                    for(int j=0; j<n; j++){//col
                        if(map[i][j]!=0)
                            q.offer(map[i][j]); //i행의 j열 마다 큐에 담는다.
                        map[i][j] = 0;
                    }
                    int idx = 0;//col
                    while(!q.isEmpty()){
                        int num = q.poll();
                        if(map[i][idx] == 0)
                            map[i][idx] = num;
                        else if(map[i][idx] == num){
                            map[i][idx] *= 2;
                            idx++;
                        }
                        else{
                            idx++;
                            map[i][idx] = num;
                        }
                    }
                }
                break;
            case 3://right
                for(int i=0; i<n; i++){//row
                    for(int j=n-1; j>=0; j--){//col
                        if(map[i][j] != 0)
                            q.offer(map[i][j]);
                        map[i][j] = 0;
                    }
                    int idx=n-1;//col
                    while(!q.isEmpty()){
                        int num = q.poll();
                        if(map[i][idx] == 0)
                            map[i][idx] = num;
                        else if(map[i][idx] == num){
                            map[i][idx] *= 2;
                            idx--;
                        }
                        else{
                            idx--;
                            map[i][idx] = num;
                        }
                    }
                }
                break;
        }
    }
    public static void dfs(int cnt){
        if(cnt==5){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(map[i][j] != 0)
                        maxCnt = Math.max(maxCnt,map[i][j]);
                }
            }
            return;
        }
        int[][] tempMap = new int[n][n];
        copyArr(tempMap,map);
        for(int i=0; i<4; i++){ //0 1 2 3 == 상 하 좌 우
            move(i); //0 1 2 3 == 상 하 좌 우
            dfs(cnt+1);
            copyArr(map,tempMap);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0);
        bw.write(maxCnt+"");
        bw.flush();
        bw.close();
    }
}
