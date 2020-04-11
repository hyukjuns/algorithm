package programmers;

import java.util.Stack;

public class swcoding2019_paper {
    public static int[] solution(int n) {
        Stack<String> ret = new Stack<>();
        ret.add("0");
        for(int i=2; i<=n; i++){
            Stack<String> temp = new Stack<>();
            for(String s : ret){
                temp.add(s);
            }
            ret.add("0");
            while(!temp.isEmpty()){
                if(temp.pop() == "1"){
                    ret.add("0");
                }
                else{
                    ret.add("1");
                }
            }
        }
        int[] ans = new int[ret.size()];
        int idx=0;
        for(String s : ret){
            ans[idx++] = Integer.parseInt(s);
        }
        return ans;
    }
    public static void main(String[] args){
        int[] ans = solution(3);
        for(int i : ans){
            System.out.print(i+" ");
        }
    }
}
