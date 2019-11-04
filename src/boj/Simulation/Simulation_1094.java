package boj.Simulation;

import java.io.*;
import java.util.Stack;

public class Simulation_1094 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int len = 64;
        int sum = len;
        Stack<Integer> stk = new Stack<>();
        while(true) {
           if(sum == x)
               break;
           len /= 2;
           stk.add(len);
           sum=0;
           for(int i=0; i<stk.size(); i++){
               sum += stk.get(i);
           }
           if(sum > x){
               stk.pop();
           }
        }
        if(stk.isEmpty())
            bw.write(stk.size()+1+"");
        else
            bw.write(stk.size()+"");
        bw.flush();
        bw.close();
    }
}
