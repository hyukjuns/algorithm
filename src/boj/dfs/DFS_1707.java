package boj.dfs;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DFS_1707 {
    private static int RED = 1;
    private static int BLUE = -1;
    private static ArrayList<ArrayList<Integer>> graph;
    private static int[] nodeColors;

    public static void dfs(int node, int color){
        nodeColors[node] = color;

        for(int i=0; i<graph.get(node).size(); i++){
            int next = graph.get(node).get(i);
            if(nodeColors[next] == 0)
                dfs(next, -color);
        }
    }

    public static boolean isBipartiteGraph(int v){
        for(int i=1; i<=v; i++){
           for(int j=0; j<graph.get(i).size(); j++){
               int next = graph.get(i).get(j);
               if(nodeColors[i] == nodeColors[next])
                   return false;
           }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        int testCase = Integer.parseInt(br.readLine());
        while(testCase-- != 0){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph = new ArrayList<>();
            nodeColors = new int[v+1];
            for(int i=0; i<=v; i++){
                graph.add(new ArrayList<>());
                nodeColors[i] = 0;
            }

            for(int i=0; i<e; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            for(int i=1; i<=v; i++){
                if(nodeColors[i] == 0)
                    dfs(i,RED);
            }

            String result = isBipartiteGraph(v) ?  "YES" : "NO";
            bw.write(result+"\n");
        }

        bw.flush();
        bw.close();
    }
}
