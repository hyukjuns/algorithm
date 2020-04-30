package programmers.level2;

import java.util.Stack;

public class Ionpoll {
    public static int solution(String arrangement) {
        int answer = 0;
        Stack<Integer> stk = new Stack<>();
        char[] arr = arrangement.toCharArray();
        for(char c : arr){
            if(c == '('){
                stk.add(0);
            }else if(c == ')'){
                if(stk.peek()==0){
                    stk.pop();
                    if(!stk.isEmpty()){
                        int temp = stk.pop();
                        temp++;
                        stk.add(temp);
                    }
                }else{
                    int val = stk.pop();
                    answer += val + 1;
                    if(!stk.isEmpty()){
                        int temp = stk.pop();
                        temp += val;
                        stk.add(temp);
                    }
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution("()(((()())(())()))(())"));
    }
}
