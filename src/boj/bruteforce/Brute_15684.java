package boj.bruteforce;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Brute_15684 {
    static int n,m,h;
    static int[][] map;
    static int ans=Integer.MAX_VALUE;
    static boolean isEnd=false;
    public static boolean startGame(){
        for(int i=1; i<=n; i++){
            int idx = i;
            int depth = 1;
            while(depth<=h){
                if(map[depth][idx]==1) {
                    idx = idx + 1;
                }
                else if(map[depth][idx-1]==1) {
                    idx = idx - 1;
                }
                depth++;
            }
            if(idx==i)
                continue;
            else
                return false;
        }
        return true;
    }

    public static void solve(int cnt,int max) {
        if(isEnd)
            return;
        if(max == cnt){
            if(startGame())
                isEnd = true;
            return;
        }
        for(int j=1; j<=h; j++){
            for(int i=1; i<n; i++){
                if(map[j][i-1] ==0 && map[j][i] == 0 && map[j][i+1] == 0){
                    map[j][i] = 1;
                    solve(cnt+1,max);
                    map[j][i] = 0;
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
        h = Integer.parseInt(st.nextToken());
        map  = new int[h+1][n+1];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
        }

        if(m==0) {
            ans = 0;
        }
        else{
            for(int i=0; i<=3; i++){
                solve(0,i);
                if(isEnd) {
                    ans = i;
                    break;
                }
            }
        }

        //System.out.println(isEnd);
        if(ans>3)
            ans = -1;
        bw.write(ans+"");
        bw.flush();
        bw.close();
    }
}
