package programmers.Skillcheck;

public class lev1_3 {
    public String solution(int n) {
        String ans="";
        int mok = n/2;
        for(int i=0; i<mok; i++){
            ans = ans + "수박";
        }
        if(n%2 != 0){
            ans = ans +"수";
        }
        return ans;
    }
}
