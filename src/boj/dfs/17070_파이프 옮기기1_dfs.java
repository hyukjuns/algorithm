package boj.dfs; //17070 파이프 옮기기1 (dfs)
import java.io.*;
import java.util.*;

class Main{
	private static int[][] graph = null;
	
	private static int N;
	private static int[][] dir = {{0,1},{1,0},{1,1}};
	private static int cnt = 0;
	
	public static boolean isValid(int dr, int dc) {
		if(dr > 0 && dr <= N && dc > 0 && dc <= N)
			return true;
		else
			return false;
	}
	public static void dfs(int y, int x, int pipe) { //pipe -> 0: 가로, 1: 세로, 2: 대각
		if(y==N && x==N) {
			cnt++;
			return;
		}
		for(int i=0; i<3; i++) {
			if((i==0 && pipe ==1) || (i==1 && pipe ==0))  //가로 -> 세로, 세로->가로;
				continue;
			
			int nextY = y + dir[i][0];
			int nextX = x + dir[i][1];
			
			if(isValid(nextY,nextX) == false || graph[nextY][nextX] == 1 )
				continue;
			if(i==2 && (graph[y][x+1] == 1 || graph[y+1][x] == 1))
				continue;
			dfs(nextY,nextX,i);
		}
	}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		graph = new int[N+1][N+1];
		
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(1,2,0);
		bw.write(cnt+"");
		bw.flush();
		bw.close();
	}
	
	
}
class DOT{
	int r,c;	
	public DOT(int r, int c) {
		this.r = r;
		this.c = c;
	}
}
