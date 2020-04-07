package programmers;

import java.util.*;

public class Kakao_findRoad {
    static int index=0;

    static void preorder(int[] order, Node root){
        if(root != null){
            order[index++] = root.value;
            preorder(order, root.left);
            preorder(order, root.right);
        }
    }
    static void postorder(int[] order, Node root){
        if(root != null){
            postorder(order, root.left);
            postorder(order, root.right);
            order[index++] = root.value;
        }
    }
    static int[][] solution(int[][] nodeinfo){
        List<Node> nodeList = new ArrayList<>();
        int idx=1;
        for(int[] node : nodeinfo){
            nodeList.add(new Node(node[0],node[1],idx++));
        }
        Collections.sort(nodeList, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.y<o2.y){
                    return 1;
                }
                else if(o1.y==o2.y){
                    if(o1.x>o2.x){
                        return 1;
                    }
                }
                return -1;
            }
        });
        Node root = nodeList.get(0);
        for(int i=1; i<nodeList.size(); i++){
            addNode(root,nodeList.get(i));
        }
        int[][] answer = new int[2][nodeinfo.length];
        preorder(answer[0], root);
        index = 0;
        postorder(answer[1], root);
        return answer;
    }

    static void addNode(Node parent, Node child){
        if(parent.x > child.x){
            if(parent.left==null){
                parent.left = child;
            }
            else{
                addNode(parent.left,child);
            }
        }
        else{
            if(parent.right==null){
                parent.right = child;
            }
            else {
                addNode(parent.right,child);
            }
        }
    }
    public static void main(String[] args){
        int[][] nodeinfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
        int[][] answer = solution(nodeinfo);
        for(int i=0; i<answer.length; i++){
            for(int j=0; j<answer[i].length; j++){
                System.out.print(answer[i][j]+" ");
            }
            System.out.println();
        }
    }
}
class Node{
    int x;
    int y;
    int value;
    Node left;
    Node right;
    public Node(int x, int y, int value){
        this.x=x;
        this.y=y;
        this.value=value;
    }
}
