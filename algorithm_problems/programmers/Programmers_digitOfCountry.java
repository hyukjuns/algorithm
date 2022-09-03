package programmers;

public class Programmers_digitOfCountry {
    public static String solution(int n) {
        String ans="";
        String[] arr = {"4","1","2"};
        while(n > 0){
            int nmg = n % 3;
            n = n/3;

            ans = arr[nmg] + ans;
            if(nmg==0)  n--;
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(solution(12));
    }
}
