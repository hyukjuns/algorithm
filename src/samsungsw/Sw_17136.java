package samsungsw;

import java.io.*;
import java.util.*;

public class Sw_17136 {
    static int[][] map = new int[10][10];
    static int[] papers = {0,0,0,0,0,0};
    static int cnt=0;
    static int ans=Integer.MAX_VALUE;

    public static boolean isRect(int dy, int dx, int len){
        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                if(map[dy+i][dx+j] != 1)
                    return false;
            }
        }
        return true;
    }

    public static void dfs(int dy, int dx, int used){
        while(map[dy][dx]!=1){
            if(++dx>=10){
                if(++dy>=10){
                    ans = Math.min(ans,used);
                    return;
                }
                dx=0;
            }
        }
        if(ans<=used)    return;

        for(int i=5; i>0; i--){
            if(dy+i>10 || dx+i >10 || papers[i]>=5)
                continue;
            if(isRect(dy,dx,i)){
                papers[i]++;
                lock(dy,dx,i,2);
                dfs(dy,dx,used+1);
                papers[i]--;
                lock(dy,dx,i,1);
            }
        }
    }

    public static void lock(int dy, int dx, int len, int mask){
        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                map[dy+i][dx+j] = mask;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        for(int i=0; i<10; i++){
            st=  new StringTokenizer(br.readLine());
            for(int j=0; j<10; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1) {
                    cnt++;
                }
            }
        }
        dfs(0,0,0);

        if(ans>25)
            ans=-1;
        bw.write(ans+"");
        bw.flush();
        bw.close();
    }
    public static void print(int idx){
        System.out.println(idx);
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
}
