package boj.dfs;//6603 로또 dfs, 백트랙킹
import java.io.*;
import java.util.*;
/*  cnt로 백트래킹 해주며 dfs알고리즘 사용  
https://www.acmicpc.net/problem/6603 */
public class dfs {
	
	public static String[] arr=null;
	public static int k;
	public static StringBuilder res=null;
	
	public static void dfs(int v, String str,int cnt) {
		if(cnt==6) {
			res.append(str+"\n");
			return;
		}
		for(int i=v+1; i<k; i++) { //이전값 후 부터 숫자 고르기
			dfs(i, str+" "+arr[i],cnt+1);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		while(true) {
			String str = br.readLine();
			st = new StringTokenizer(str);
			k = Integer.parseInt(st.nextToken());
			if(k==0)
				break;
			arr = new String[k];
			res = new StringBuilder();
			for(int i=0; i<k; i++) {
				arr[i] = st.nextToken();
			}
			for(int i=0; i<k; i++) {
				dfs(i,arr[i],1);
			}
			bw.write(res.toString()+"\n");
		}
		bw.flush();
		bw.close();
	}
}
