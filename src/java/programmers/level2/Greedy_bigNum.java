package programmers.level2;

public class Greedy_bigNum {

    public static String solution(String number, int k) {
        int len = number.length();
        int size = number.length() - k;
        int start=0;
        int end;
        char target;
        StringBuilder answer = new StringBuilder();
        for(int i=0; i<size; i++){
            int max=0;
            target='0';
            end = len - (size-i);
            for(int j=start; j<=end; j++){
                char temp = number.charAt(j);
                if(max < temp -'0'){
                    target = temp;
                    max = temp -'0';
                    start = j+1;
                }
            }
            answer.append(target);
        }

        return answer.toString();
    }

   public static void main(String[] args) {
        String num = "10000";
        int k=2;
        System.out.println(solution(num,k));
   }
}
