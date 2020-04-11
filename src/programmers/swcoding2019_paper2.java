package programmers;

public class swcoding2019_paper2 {
    public int[] solution(int n) {
        String[] dp = new String[n+1];
        dp[1] = "0";
        for(int i=2; i<=n; i++){
            StringBuilder sb = new StringBuilder(dp[i-1]);
            sb = sb.reverse();
            String reverse = sb.toString();
            reverse = reverse.replace("0","2");
            reverse = reverse.replace("1","0");
            reverse = reverse.replace("2","1");
            dp[i] = dp[i-1] + "0" + reverse;
        }
        int[] answer = new int[dp[n].length()];
        for(int i=0; i<answer.length; i++){
            answer[i] = dp[n].charAt(i)-'0';
        }
        return answer;
    }
}
