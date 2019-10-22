package boj.dfs; //1987 알파벳 DFS + 백트래킹
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
public class DFS_1987 {
    public static char[][] graph = null;
    public static boolean[] visited = null;
    public static int row,col;
    public static int cnt=0;
    public static int maxCnt=0;
    public static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    public static boolean isValid(int dy, int dx){
        return (dy>=0 && dy<row) && (dx>=0 && dx<col);
    }
    public static void dfs(int y, int x, char alpha){
        visited[alpha] = true;
        cnt++;
        if(maxCnt < cnt){//최대값 구하기
            maxCnt = cnt;
        }
        int dy,dx;
        for(int i=0; i<4; i++){
            dy = y + dir[i][0];
            dx = x + dir[i][1];
            if(isValid(dy,dx) && visited[graph[dy][dx]] == false){
                dfs(dy,dx,graph[dy][dx]);
                visited[graph[dy][dx]] = false; //백트래킹
                cnt--;//백트래킹
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        graph = new char[row][col];
        visited = new boolean[91];
        for(int i=65; i<=90; i++) {
            visited[i] = false;
        }
        for(int i=0; i<row; i++){
            String str = br.readLine();
            for(int j=0; j<col; j++){
                graph[i][j] = str.charAt(j);
            }
        }
        dfs(0,0,graph[0][0]);
        bw.write(maxCnt+"");
        bw.flush();
        bw.close();
    }
}
