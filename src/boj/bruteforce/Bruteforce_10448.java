package boj.bruteforce;

import java.io.*;
import java.util.ArrayList;

public class Bruteforce_10448 {
    static boolean flag;
    public static void dfs(ArrayList<Integer> tri, int cnt,int target, int k){
        if(cnt==3){
            if(target == k) {
                flag = true;
                return;
            }
            return;
        }
        for(int i=0; i<tri.size(); i++){
            dfs(tri, cnt + 1, target + tri.get(i), k);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            int k = Integer.parseInt(br.readLine());
            int n=1;
            ArrayList<Integer> tri = new ArrayList<>();
            while((n * (n + 1)) / 2 < k){
                tri.add((n * (n + 1)) / 2);
                n++;
            }
            flag = false;
            dfs(tri, 0,0,k);
            if(flag)
                bw.write("1"+"\n");
            else
                bw.write("0"+"\n");
        }
        bw.flush();
        bw.close();
    }
}
