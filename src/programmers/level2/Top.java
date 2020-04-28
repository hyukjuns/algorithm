package programmers.level2;

import java.util.Stack;

public class Top {
    public static int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        Stack<tops> stk = new Stack<>();
        int idx=1;
        for(int i : heights){
            stk.add(new tops(idx, i));
            idx++;
        }
        Stack<tops> q = new Stack<>();
        while(!stk.isEmpty()){
            tops temp = stk.pop();
            if(q.isEmpty()){
                q.add(temp);
            }else {
                while(!q.isEmpty() && q.peek().val < temp.val){
                    tops target = q.pop();
                    answer[target.idx-1] = temp.idx;
                }
                q.add(temp);
            }
        }
        while(!q.isEmpty()){
            answer[q.pop().idx-1] = 0;
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] heights = {1,5,3,6,7,6,5};
        int[] result = solution(heights);
        for(int i : result){
            System.out.print(i+" ");
        }
    }
}
class tops{
    int idx;
    int val;
    public tops(int idx, int val){
        this.idx=idx;
        this.val=val;
    }
}
