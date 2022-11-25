package boj.tree;

import java.io.*;
import java.util.StringTokenizer;

public class Tree_1991 {
    static int n;
    static BinaryTree[] tree;

    static void preorderTraversal(BinaryTree node){
        System.out.print(node.value);
        if(node.left != '.'){
            for(int i=0; i<n; i++){
                if(node.left == tree[i].value){
                    preorderTraversal(tree[i]);
                }
            }
        }
        if(node.right != '.'){
            for(int i=0; i<n; i++){
                if(node.right == tree[i].value){
                    preorderTraversal(tree[i]);
                }
            }
        }
    }
    static void inorderTraversal(BinaryTree node){
        if(node.left != '.'){
            for(int i=0; i<n; i++){
                if(node.left == tree[i].value){
                    inorderTraversal(tree[i]);
                }
            }
        }
        System.out.print(node.value);
        if(node.right != '.'){
            for(int i=0; i<n; i++){
                if(node.right == tree[i].value){
                    inorderTraversal(tree[i]);
                }
            }
        }
    }
    static void postorderTraversal(BinaryTree node){
        if(node.left != '.'){
            for(int i=0; i<n; i++){
                if(node.left == tree[i].value){
                    postorderTraversal(tree[i]);
                }
            }
        }
        if(node.right != '.'){
            for(int i=0; i<n; i++){
                if(node.right == tree[i].value){
                    postorderTraversal(tree[i]);
                }
            }
        }
        System.out.print(node.value);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        tree = new BinaryTree[n];
        for(int i=0; i<n; i++){
            String[] str = br.readLine().split(" ");
            char node = str[0].charAt(0);
            char left = str[1].charAt(0);
            char right = str[2].charAt(0);
            tree[i] = new BinaryTree(node, left, right);
        }
        preorderTraversal(tree[0]);
        System.out.println();
        inorderTraversal(tree[0]);
        System.out.println();
        postorderTraversal(tree[0]);
    }

}
class BinaryTree{
    char value;
    char left;
    char right;
    public BinaryTree(char value, char left, char right){
        this.value=value;
        this.left=left;
        this.right=right;
    }
}
