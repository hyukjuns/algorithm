package boj.MST;

import java.io.*;
import java.util.*;

public class Mst_1922 {
    static int n,m;
    static Edge[] list;

    static int getParent(int[] parent, int x){
        if(parent[x] == x)  return x;
        return parent[x] = getParent(parent,parent[x]);
    }
    static void unionParent(int[] parent, int a, int b){
        a = getParent(parent,a);
        b = getParent(parent,b);
        if(a<b) parent[b] = a;
        else    parent[a] = b;
    }
    static boolean findParent(int[] parent,int a, int b){
        a = getParent(parent,a);
        b = getParent(parent,b);
        if(a == b)  return true;
        else    return false;
    }

    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        list = new Edge[m];
        int a,b,c;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            list[i] = new Edge(a,b,c);
        }
        Arrays.sort(list, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.distance>o2.distance ? 1 : (o1.distance==o2.distance) ? 0 : -1;
            }
        });

        int[] set = new int[n+1];
        for(int i=1; i<=n; i++){
            set[i] = i;
        }

        int sum=0;
        for(int i=0; i<m; i++){
            if(!findParent(set,list[i].node[0],list[i].node[1])){
                sum += list[i].distance;
                unionParent(set,list[i].node[0],list[i].node[1]);
            }
        }

        bw.write(sum+"");
        bw.flush();
        bw.close();
    }
}
class Edge{
    int[] node = new int[2];
    int distance;
    public Edge(int a, int b, int distance){
        this.node[0] = a;
        this.node[1] = b;
        this.distance = distance;
    }
}