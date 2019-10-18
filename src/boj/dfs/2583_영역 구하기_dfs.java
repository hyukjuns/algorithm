package boj.dfs;//2583 영역구하기 dfs
import java.io.*;
import java.util.*;

public class dfs {
	private static int m,n,k;
	private static int[][] graph = null;
	private static boolean[][] visited = null;
	private static int cnt;
	private static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	
	public static boolean isValid(int dy,int dx) {
		return (dy>=0 && dy<m) && (dx>=0 && dx<n);
	}
	public static void dfs(int y, int x) {
		visited[y][x] = true;
		cnt++;
		int dy,dx;
		for(int i=0; i<4; i++) {
			dy = y + dir[i][0];
			dx = x + dir[i][1];
			if(isValid(dy,dx) && graph[dy][dx]==0 && visited[dy][dx] == false) {
				dfs(dy,dx);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		graph = new int[m][n];
		visited = new boolean[m][n];
		ArrayList<Integer> res = new ArrayList<>();
		
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int x1,y1,x2,y2;
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			for(int y=y1; y<y2; y++) {
				for(int x=x1; x<x2; x++) {
					graph[y][x] = 1;
				}
			}
		}
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(graph[i][j] == 0 && visited[i][j] == false) {
					cnt=0;
					dfs(i,j);
					res.add(cnt);
				}
			}
		}
		int[] arr = new int[res.size()];
		for(int i=0; i<res.size(); i++) {
			arr[i] = res.get(i);
		}
		Arrays.sort(arr);
		bw.write(res.size()+"\n");
		for(int i=0; i<res.size(); i++) {
			bw.write(arr[i]+" ");
		}
		bw.flush();
		bw.close();
		
	}
}
