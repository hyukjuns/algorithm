package samsungsw;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Kruskal_Algorithm {
    static int getParent(int[] parent, int x){
        if(parent[x]==x)    return x;
        return parent[x] = getParent(parent,parent[x]);
    }
    static void unionParent(int[] parent, int a, int b){
        a = getParent(parent,a);
        b = getParent(parent,b);
        if(a < b)   parent[b] = a;
        else    parent[a] = b;
    }
    static boolean find(int[] parent, int a, int b){
        a = getParent(parent,a);
        b = getParent(parent,b);
        if(a == b)  return true;
        else    return false;
    }

    public static void main(String[] args) throws IOException{
        int n = 7;
        int m = 11;
        LinkedList<Edge> list = new LinkedList<>();
        list.add(new Edge(1,7,12));
        list.add(new Edge(1,4,28));
        list.add(new Edge(1,2,67));
        list.add(new Edge(1,5,17));
        list.add(new Edge(2,4,24));
        list.add(new Edge(2,5,62));
        list.add(new Edge(3,5,20));
        list.add(new Edge(3,6,37));
        list.add(new Edge(4,7,13));
        list.add(new Edge(5,6,45));
        list.add(new Edge(5,7,73));
        Collections.sort(list, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.distance > o2.distance ? 1 : (o1.distance==o2.distance) ? 0 : -1;
            }
        });
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i).distance);
        }
        int[] set = new int[n];
        for(int i=0; i<n; i++){
            set[i]=i;
        }

        int sum=0;
        for(int i=0; i<list.size(); i++){
            if(!find(set, list.get(i).node[0]-1, list.get(i).node[1]-1)){
                sum += list.get(i).distance;
                unionParent(set,list.get(i).node[0]-1,list.get(i).node[1]-1);
            }
        }

        System.out.println(sum);
    }
}
class Edge {
    int[] node = new int[2];
    int distance;
    public Edge(int a, int b, int distance){
        this.node[0] = a;
        this.node[1] = b;
        this.distance = distance;
    }
}
