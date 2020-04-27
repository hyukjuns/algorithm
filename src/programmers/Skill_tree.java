package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Skill_tree {
    public static int solution(String skill, String[] skill_trees) {
        int ans=0;
        for(String str : skill_trees){
            Queue<Character> order = new LinkedList<>();
            for(Character c : skill.toCharArray()){
                order.add(c);
            }

            boolean available = false;
            char[] temp = str.toCharArray();
            for(Character c : temp){
                if(!order.contains(c)){
                    available = true;
                    continue;
                } else {
                   if(!order.isEmpty() && order.peek() == c){
                       available = true;
                       order.poll();
                   }else if(!order.isEmpty() && order.peek() != c){
                       available = false;
                       break;
                   }else if(order.isEmpty()){
                       available = true;
                   }
                }
            }
            if(available){
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        System.out.println(solution(skill, skill_trees));
    }
}
