package boj.backtracking;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Backtracking_1759 {
    static char[] candiCode;
    static boolean[] used;
    static int l,c;
    public static boolean checkAlpha(String str){
        int a=0,b=0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i'
                    || str.charAt(i) =='o' || str.charAt(i) =='u'){
                a++;
            }
            else
                b++;
        }
        if(a >= 1 && b >= 2)
            return true;
        else
            return false;
    }
    public static void dfs(String str, int cnt, int idx){
        if(cnt == l){
            //모음 A E I O U
            if(checkAlpha(str)) {
                System.out.println(str);
                return;
            }
        }
        else {
            for (int i = idx; i < c; i++) {
                if (!used[i]) {
                    used[i] = true;
                    dfs(str + String.valueOf(candiCode[i]), cnt + 1, i);
                    used[i] = false;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        candiCode = new char[c];
        used = new boolean[c];
        String str = br.readLine();
        str = str.replace(" ","");
        for(int i=0; i<str.length(); i++){
            candiCode[i] = str.charAt(i);
        }
        Arrays.sort(candiCode);
        dfs("",0,0);
    }
}
