package dev_matching_2020;


public class solution1 {
    public static int solution(String p, String s) {
        int result=0;
        for(int i=0; i<p.length(); i++){
            int password = p.charAt(i)-'0';
            int target = s.charAt(i)-'0';
            int cnt1=0;
            int cnt2=0;
            if(password != target){
                int temp = password;
                //정
                while(temp != target){
                    cnt1++;
                    temp++;
                    if(temp == 10){
                        temp = 0;
                    }
                }
                //역
                temp=password;
                while(temp != target){
                    cnt2++;
                    temp--;
                    if(temp == -1){
                        temp = 9;
                    }
                }
            }
            if(cnt1>=cnt2){
                result += cnt2;
            }
            else{
                result += cnt1;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String p = "00000000000000000000";
        String s = "91919191919191919191";
        System.out.println(solution(p,s));
    }
}
