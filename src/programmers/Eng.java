package programmers;//2018 서머코딩 영어 끝말잇기
import java.util.Stack;

public class Eng {
    public static int[] solution(int n, String[] words) {
        int[] answer = {};
        Stack<String> stk = new Stack<>();

        int id=0;
        int turn=1;
        stk.add(words[0]);

        for(int i=1; i<words.length; i++){
            id++;
            if(stk.contains(words[i])){//이전에 사용한 단어인지
                answer = new int[]{id+1, turn};
                break;
            }
            String temp = stk.peek();
            //System.out.println("peek: "+stk.peek());
            if(temp.charAt(temp.length()-1) != words[i].charAt(0)){// 이전글자의 마지막 철자로 시작하는지
               answer = new int[]{id+1, turn};
                break;
            }
            stk.add(words[i]);
            if(id == n-1){
                id = -1;
                turn++;
            }
        }
        if(answer.length==0) //탈락자 없을경우
            answer = new int[]{0,0};
       // Iterator it = stk.iterator();
        //while(it.hasNext()){
          //  System.out.println(it.next());
       // }
        return answer;
    }
    public static void main(String[] args){
        String[] words = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
        int[] res = solution(5,words);
        System.out.println(res[0]+","+res[1]);
    }
}
