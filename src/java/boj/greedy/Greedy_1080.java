package boj.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class Greedy_1080 {
    private static int[][] a,b;
    private static int n,m;
    private static int result;
    public static boolean isSame(int[][] a, int[][] b){
        for(int i=0; i<a.length; i++){
            for(int j=0; j<a[i].length; j++){
                if(a[i][j] != b[i][j])
                    return false;
            }
        }
        return true;
    }
    public static void ac(int dy, int dx){
        for(int i=dy; i<dy+3; i++){
            for(int j=dx; j<dx+3; j++){
                a[i][j] = 1 - a[i][j];
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[n][m];
        b = new int[n][m];
        for(int i=0; i<n; i++){
            String temp = br.readLine();
            for(int j=0; j<m; j++){
                a[i][j] = temp.charAt(j) -'0';
            }
        }
        for(int i=0; i<n; i++){
            String temp = br.readLine();
            for(int j=0; j<m; j++){
                b[i][j] = temp.charAt(j) -'0';
            }
        }
        sol(0);
        bw.write(result+"");
        bw.flush();
        bw.close();
    }
    public static void sol(int cnt){
        boolean flag = false;
        if(n<3 || m<3){
          flag = isSame(a,b);
        }
        else {
            for (int i = 0; i <= n - 3; i++) {
                for (int j = 0; j <= m - 3; j++) {
                    if (a[i][j] != b[i][j]) {
                        ac(i, j);
                        cnt++;
                    }
                    if (isSame(a, b)) {
                        flag = true;
                        break;
                    }
                }
            }
        }
       if(flag)
           result = cnt;
       else
           result = -1;
    }
}
