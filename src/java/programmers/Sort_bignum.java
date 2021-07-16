package programmers;

public class Sort_bignum {
    static class Solution {
        static boolean[] used;
        static int max = Integer.MIN_VALUE;
        public static void dfs(int[] numbers, int v, String str, int cnt){
            if(cnt==numbers.length){
                if(max < Integer.parseInt(str))
                    max = Integer.parseInt(str);
                return;
            }
            for(int i=0; i<numbers.length; i++){
                if(!used[i]){
                    used[i] = true;
                    dfs(numbers, i, str + String.valueOf(numbers[i]),cnt+1);
                    used[i] = false;
                }
            }
        }
        public String solution(int[] numbers) {
            used = new boolean[numbers.length];
            for(int i=0; i<numbers.length; i++){
                if(!used[i]){
                    used[i] = true;
                    dfs(numbers, i, String.valueOf(numbers[i]),1);
                    used[i] = false;
                }
            }
            String answer =  String.valueOf(max);
            return answer;
        }
    }
}
