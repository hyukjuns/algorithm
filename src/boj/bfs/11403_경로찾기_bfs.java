package boj.bfs; //11403 경로찾기 (bfs)
import java.io.*;
import java.util.*;
/* 풀이 :  bfs 를 한 행마다 호출, v=0,1,2
	 v=0일때  큐에는 0 -> 1 -> 2-> 0 으로 들어가며 그게 point 가 되어  graph[point][j]로 정점간 연결상태 확인 후 result배열에 1로 셋팅
	 ex)
	 graph  0 1 0   즉 (0,1) (1,2) (2,0) 끼리 연결되있음, 0->1->2->0 구조
	 	0 0 1
		1 0 0
	
	v==0	result[0][j] q(0,1,2,0) <- j 값들
			v
		result  0 1 1 1
			1
			2
	
	v==1	result[1][j] q(1,2,0)
			v		
		result  0 1 1 1
			1 1 1 1
			2 
			
	v==2 result[2][j] q(2,0,1)
			v	
		result	0  1 1 1
			1  1 1 1
			2  1 1 1
					*/
	
public class bfs {
	public static int N;
	public static int[][] graph=null;
	public static int[][] result = null;
	public static boolean[] visited = null;
	
	public static void bfs(int v) {
		Deque<Integer> q = new LinkedList<>();
		visited = new boolean[N];
		q.add(v);
		while(!q.isEmpty()) {
			int point = q.poll();
			for(int j=0; j<N; j++) {
				if(graph[point][j]==1 && visited[j] != true) { //point가 q의 값들로 바뀌면서 정점끼리의 연결 상태 확인
					visited[j] = true; //방문 체크
					q.add(j); // j 가 큐에 삽입됨
					result[v][j] = 1; //결과배열에는 v가 고정되어 있으므로 한 행 별로 처리됨, 각 행 별로 j열에 1이 셋팅
							/* 예를 들어 
							0행은 graph에서 0->1(j) 이므로 result의 0(v)행 1열에 1 셋, 그다음 큐에 1삽입
							point 1로 바뀜, 그다음 1->2(j) 이므로 result의 0행 2열에 1 셋, 큐에 2삽입
							point 2로 바뀜, 그다음 2->0(j) 이므로 result의 0행  0열에 1 셋, 큐에 0 삽입
							v==0일때 종료.*/
				}
			}
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		graph = new int[N][N];
		result = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<N; i++) { //한 행씩 진행;
			bfs(i);
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				bw.write(result[i][j]+" ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
}
