package boj.dfs;
import java.io.*;
import java.util.*;

public class dfs {
	private static int n;
	private static int cnt;
	private static int[][] graph = null;
	private static int[][] temp = null;
	private static boolean[][] visited = null;
	private static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	
	public static boolean isValid(int dy, int dx) {
		return (dy>=0 && dy<n) && (dx>=0 && dx<n);
	}
	public static void dfs(int id, int y, int x) {
		visited[y][x] = true;
		temp[y][x] = id;
		int dy,dx;
		for(int i= 0; i<4; i++) {
			dy = y + dir[i][0];
			dx = x + dir[i][1];
			if(isValid(dy,dx) && temp[dy][dx] != 0 && visited[dy][dx] == false) {
				dfs(id,dy,dx);
			}
		}
		
	}
	public static void copyArr() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				temp[i][j] = graph[i][j];
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		graph = new int[n][n];
		
		int res = 0;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int height=1; height<100; height++) {
			temp = new int[n][n];
			visited = new boolean[n][n];
			copyArr();
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(height >= graph[i][j]) {
						temp[i][j] = 0; //0이면 물에잠김
					}
				}
			}//물에 잠기는거 완료
			cnt=0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(temp[i][j] != 0 && visited[i][j] == false) {
						dfs(++cnt,i,j); //안전영역 갯수 파악
					}
				}
			}
			
			if(res<cnt)
				res = cnt;
		}
		if(res==0)//물에 잠기는 구역이 없을경우 맵 전체를 안전구역 1곳으로 생각
			res=1;
		bw.write(res+"");
		bw.flush();
		bw.close();
	}
}