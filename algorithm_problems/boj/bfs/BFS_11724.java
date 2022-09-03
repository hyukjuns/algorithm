package boj.bfs; //11724 연결 요소의 개수 bfs
import java.io.*;
import java.util.*;

class BFS_11724 {
	
	public static int[][] graph=null;
	public static boolean[] visited = null;
	public static int N,M;
	public static int cnt=0;
	public static boolean flag;
	public static void bfs(int v) { //호출되면 아직 방문하지 않았고, 연결요소가 있다는 뜻
		Deque<Integer> q = new LinkedList<>();
		q.add(v);
		
		while(!q.isEmpty()) {
			int val = q.poll();
			for(int i=1; i<=N; i++) {
				if(graph[val][i] == 1 && visited[i] == false) {
					q.add(i);
					visited[i] = true;
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
		graph  = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		int a,b;
		for(int i=0; i<M; i++) { //무방향 이므로 인접행렬이 대칭구조를 이룸
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			graph[a][b] = graph[b][a] = 1;
		}
		for(int i=1; i<=N; i++) {
			if(visited[i]==false) { //방문하지 않았던 노드면 bfs호출 후 카운트
				bfs(i);
				cnt++;
			}
		}
		bw.write(cnt+"");
		bw.flush();
		bw.close();
	}
}
