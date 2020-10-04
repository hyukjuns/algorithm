package boj.Simulation;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Simul_2161 {
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new LinkedList<>();
        for(int i=1; i<=n; i++){
            dq.add(i);
        }
        while(!dq.isEmpty()){
            bw.write(dq.pollFirst()+" ");
            if(dq.isEmpty())    break;
            dq.addLast(dq.pollFirst());
        }
        bw.flush();
        bw.close();
    }
}
