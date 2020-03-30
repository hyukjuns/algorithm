package boj.tree;

import java.util.Scanner;

public class Tree_1068 {
    static int n;
    static int[][] graph;
    static boolean[] visited;
    static int cnt=0;

    static void dfs(int v){
        boolean isLeaf = true;
        visited[v] = true;
        for(int i=0; i<n; i++){
           if(!visited[i] && graph[v][i]==1){
               isLeaf = false; //if문에 걸리면 리프노드 아님
               dfs(i);
           }
        }
        if(isLeaf){// 리프노드이면 카운트++
            cnt++;
        }
    }
    static void deleteNode(int target){
        for(int i=0; i<n; i++){
            graph[target][i] = graph[i][target] = 0;
        }
        visited[target] = true;//루트가 제거될 경우 대비
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        graph = new int[n][n];
        visited = new boolean[n];
        int root=0;
        for(int i=0; i<n; i++){
            int parent = sc.nextInt();
            if(parent==-1) {
                root = i;
                continue;
            }
            graph[i][parent] = graph[parent][i] = 1; //양방향 그래프 생성
        }
        int target = sc.nextInt();
        if(n==1 && target==0){//단일노드인데 제거할 경우
            System.out.println(0);
            return;
        }
        else if(n==1 && target != 0){ //단일노드인데 제거 안할 경우
            System.out.println(1);
            return;
        }
        deleteNode(target);
        if(!visited[root]){//루트가 제거되면 탐색할 필요 없음
            dfs(root);
        }
        System.out.println(cnt);
    }
}

