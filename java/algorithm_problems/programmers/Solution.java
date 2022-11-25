package programmers;

import java.util.LinkedList;
import java.util.Queue;

class FunctionDevelop {
    public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Prog> q = new LinkedList<>();
        for(int i =0; i<progresses.length; i++){
            q.add(new Prog(progresses[i],speeds[i]));
        }

        Queue<Integer> result = new LinkedList<>();
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                Prog temp = q.poll();
                temp.progress += temp.speed;
                q.add(temp);
            }
            int cnt=0;
            while(!q.isEmpty() && q.peek().progress >= 100){
                cnt++;
                q.poll();
            }
            if(cnt > 0){
                result.add(cnt);
            }
        }
        int[] answer = new int[result.size()];
        int idx=0;
        while(!result.isEmpty()){
            answer[idx++] = result.poll();
        }
        return answer;
    }
    public static void main(String[] srgs){
       int[] progresses = {93,30,55};
       int[] speeds = {1,30,5};
       int[] ans = solution(progresses,speeds);
       for(int i: ans){
           System.out.print(i+" ");
       }
    }
}
class Prog {
    int progress;
    int speed;
    public Prog(int progress, int speed){
        this.progress = progress;
        this.speed = speed;
    }
}
