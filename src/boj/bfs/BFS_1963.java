package boj.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS_1963 {
    static boolean[] visited;
    static boolean[] primes = new boolean[10000];
    static int min;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        getPrime();
        int testCase = Integer.parseInt(br.readLine());
        while(testCase-- > 0){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            visited = new boolean[10000];
            min = Integer.MAX_VALUE;
            bfs(from,to);
            if(min == Integer.MAX_VALUE){
                bw.write("Impossible");
            }
            else{
                bw.write(min+"\n");
            }
        }
        bw.flush();
        bw.close();




    }
    public static void bfs(int start, int end){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start,0));

        while(!q.isEmpty()){
            Node cur = q.poll();
            if(cur.num == end){
                min = Math.min(min, cur.cnt);
            }
            String sCur = String.valueOf(cur.num);
            for(int i=0; i<4; i++){
                for(int j = (i == 0 ? 1 : 0); j<10; j++){
                    int next = Integer.parseInt(getNext(sCur, i, j));
                    if(next>=1000 && primes[next]==false && !visited[next]){
                        q.add(new Node(next, cur.cnt+1));
                        visited[next] = true;
                    }
                }
            }
        }
    }
    public static String getNext(String str, int index, int insert){
        return str.substring(0,index) + insert + str.substring(index+1);
    }
     public static void getPrime(){
        // if prime, value is false;
        double max = Math.sqrt(primes.length);
        for(int i=2; i<=max; i++){
            if(primes[i]==true) continue;
            else{
                for(int j = i+i; j<primes.length; j+=i){
                    primes[j] = true;
                }
            }
        }

    }
}
class Node{
    int num;
    int cnt;
    public Node(int num, int cnt){
        this.num=num;
        this.cnt=cnt;
    }
}
