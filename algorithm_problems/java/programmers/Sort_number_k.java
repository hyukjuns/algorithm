package programmers;
import java.util.Arrays;

public class Sort_number_k {
    class Solution {
        public int[] solution(int[] array, int[][] commands) {
            int[] answer = new int[commands.length];
            for(int i =0; i<commands.length; i++){
                int start = commands[i][0];
                int end = commands[i][1];
                int k = commands[i][2];
                int[] temp = new int[end-start+1];
                int idx=0;
                for(int j=start-1; j<end; j++){
                    temp[idx++] = array[j];
                }
                Arrays.sort(temp);
                answer[i] = temp[k-1];
            }
            return answer;
        }
    }
}
