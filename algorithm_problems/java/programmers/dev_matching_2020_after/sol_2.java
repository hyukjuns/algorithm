package programmers.dev_matching_2020_after;

import java.util.LinkedList;
import java.util.Queue;

public class sol_2 {
    public static void main(String[] args){
        int[][] g = {{1, 5},{2, 7},{4, 8},{3, 6}};
        System.out.println(solution(10,g));
    }
    public static int solution(int n, int[][] groups) {
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            q.add(i);
        }
        while(!q.isEmpty()){

        }
        return 1;
    }
}
