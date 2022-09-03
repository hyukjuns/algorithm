package boj.bfs;//14502 연구소 bfs. brute force
import java.io.*;
import java.util.*;
/* 
	https://www.acmicpc.net/problem/14502
	1. brute force 식으로 벽을 3개 세운다
 	2. bfs 로 바이러스 전파
   	3. 안전지역 갯수 카운트하여 최대값 획득
*/
class BFS_14502 {
		
	public static int[][] graph = null;
	public static int[][] temp = null;
	public static int N,M;
	public static int[][] dir = {{1,0},{-1,0},{0,-1},{0,1}};
	public static int max=0;
	
	public static boolean isValid(int dy, int dx) {
		if((dy>=0 && dy<N)&&(dx>=0 && dx<M))
			return true;
		else
			return false;
	}
	
	public static void vspread() {
		int[][] spread = new int[N][M];
		for(int i=0; i<N; i++) { //배열 복사
			for(int j=0; j<M; j++) {
				spread[i][j] = temp[i][j];
			}
		}
		
		Deque<DOT> q = new LinkedList<>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(spread[i][j]==2)
					q.add(new DOT(i,j));
			}
		}
		while(!q.isEmpty()) {
			DOT tmp = q.poll();
			for(int i=0; i<4; i++) {
				int dy = tmp.y + dir[i][0];
				int dx = tmp.x + dir[i][1];
				if(isValid(dy,dx) && spread[dy][dx]==0) {
					spread[dy][dx] = 2;
					q.add(new DOT(dy,dx));
				}
			}
		}
		
		int safe=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(spread[i][j] == 0)
					safe++;
			}
		}
		if(max < safe)
			max = safe;
		
	}
	public static void set_wall(int cnt) {
		if(cnt==3) { //벽 3개 세운 후 바이러스 전파
			vspread();
			return;
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(temp[i][j]==0) {
					temp[i][j] = 1;
					set_wall(cnt+1);
					temp[i][j] = 0; //재귀 호출 후 원상 복귀
				}
			}
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N][M];
		temp = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(graph[i][j]==0) {
					for(int k=0; k<N; k++) { //배열 복사
						for(int l=0; l<M; l++) {
							temp[k][l] = graph[k][l];
						}
					}
					temp[i][j]=1;
					set_wall(1);
					temp[i][j]=0; //재귀 호출 후 원상 복귀
				}
			}
		}
		bw.write(max+"");
		bw.flush();
		bw.close();
	}
}
class DOT {
	int y;
	int x;
	public DOT(int y, int x) {
		this.y = y;
		this.x = x;
	}
}
