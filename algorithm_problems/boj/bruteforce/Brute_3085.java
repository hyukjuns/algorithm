package boj.bruteforce;

import java.io.*;

public class Brute_3085 {
    static int n;
    static char[][] map;
    static int ans=0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        for(int i=0; i<n; i++){
            String temp = br.readLine();
            for(int j=0; j<n; j++){
                map[i][j] = temp.charAt(j);
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n-1; j++){
                char temp = map[i][j];
                map[i][j] = map[i][j+1];
                map[i][j+1] = temp;
                check();
                map[i][j+1] = map[i][j];
                map[i][j] = temp;

                char temp2 = map[j][i];
                map[j][i] = map[j+1][i];
                map[j+1][i] = temp2;
                check();
                map[j+1][i] = map[j][i];
                map[j][i] = temp2;
            }
        }
        bw.write(ans+"");
        bw.flush();
        bw.close();
    }
    public static void check(){
        for(int i=0; i<n; i++){
            int cnt=1;
            for(int j=0; j<n-1; j++){
                if(map[i][j] == map[i][j+1]){
                    cnt++;
                }else{
                    ans = Math.max(ans, cnt);
                    cnt=1;
                }
            }
            ans = Math.max(ans,cnt);
        }
        for(int i=0; i<n; i++){
            int cnt=1;
            for(int j=0; j<n-1; j++){
                if(map[j][i] == map[j+1][i]){
                    cnt++;
                }else{
                    ans = Math.max(ans,cnt);
                    cnt=1;
                }
            }
            ans = Math.max(ans,cnt);
        }
    }
}
