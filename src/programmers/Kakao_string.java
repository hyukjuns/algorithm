package programmers;

public class Kakao_string {
    class Solution {
        public int solution(String s) {
            int tc = s.length()/2;
            int min = Integer.MAX_VALUE;
            if(tc==0){//길이기 1일때
                return 1;
            }
            for(int len=1; len<=tc; len++){
                int i;
                int cnt=1;
                String result="";
                String temp="";
                for(i=0; i<s.length()-len; i+=len){
                    temp = s.substring(i,i+len);
                    if(i+(2*len)>s.length())
                        break;
                    if(temp.equals(s.substring(i+len, i+len + len)))
                        cnt++;
                    else{
                        if(cnt != 1){
                            result += String.valueOf(cnt)+temp;
                            cnt = 1;
                        }
                        else{
                            result += temp;
                        }
                    }
                }
                if(cnt != 1){//중복된게 있을때
                    result += String.valueOf(cnt)+temp;//중복된것 넣고
                    if(i+len <= s.length()) // 그리고 나머지가 있다면
                        result += s.substring(i+len);
                }
                else
                    result += s.substring(i);//나머지 모두 넣기
                if(min > result.length())
                    min = result.length();
            }
            return min;
        }
    }
}
