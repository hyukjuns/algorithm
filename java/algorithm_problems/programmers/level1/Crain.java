package programmers.level1;

import java.io.*;
import java.util.Stack;

public class Crain {
    public static int solution(int[][] board, int[] moves) {
       int row = board.length;
       int cnt=0;

       Stack<Integer> stk = new Stack<>();
       for(int index : moves){
           int temp=0;
           for(int i=0; i<row; i++){
               if(board[i][index-1] != 0){
                   temp = board[i][index-1];
                   board[i][index-1] = 0;
                   break;
               }
           }
           if(temp==0) {
               continue;
           }
           if(!stk.isEmpty() && stk.peek()==temp){
               stk.pop();
               cnt += 2;
           }else{
               stk.add(temp);
           }
       }
       return cnt;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        int res = solution(board,moves);
        bw.write(res+"");
        bw.flush();
        bw.close();

    }
}
