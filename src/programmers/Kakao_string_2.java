package programmers;

import java.util.Stack;

class Solution {

        public static String reverse(String str) {
            int strLen = str.length();
            StringBuffer sb = new StringBuffer();
            for(int i = 0 ; i < strLen; i++) {
                if(str.charAt(i) == ')') {
                    sb.append('(');
                }else
                    sb.append(')');
            }
            return sb.toString();
        }

        public static boolean checkIsRight(String str){
            int strLen = str.length();
            Stack<Character> stack = new Stack<>();
            stack.push(str.charAt(0));
            for(int i=1; i<strLen; i++){
                if(stack.isEmpty() || stack.peek() == str.charAt(i))
                    stack.push(str.charAt(i));
                else{
                    if(stack.peek() == '(')
                        stack.pop();
                    else
                        stack.push(str.charAt(i));
                }
            }
            if(stack.isEmpty())
                return true;
            else
                return false;
        }

        public static String solve(String str){
            if(str.equals("")) // 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
                return "";

            // 2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다.
            // 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
            int open=0, close=0;
            int i=0;
            while(true){
                if(str.charAt(i) == '(')
                    open++;
                else if(str.charAt(i) == ')')
                    close++;
                if(open==close)
                    break;
                i++;
            }
            String u = str.substring(0,open+close);
            String v = str.substring(open+close);
            if(checkIsRight(u) == true){// 3. 문자열 u가 "올바른 괄호 문자열" 이라면
                return u + solve(v); // 문자열 v에 대해 1단계부터 다시 수행합니다.
                // 3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
            }
            else{// 4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.

                // 4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
                // 4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
                // 4-3. ')'를 다시 붙입니다.
                String temp = "(" + solve(v) + ")";

                // 4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
                u =u.substring(1,u.length()-1);
                if(u.equals(""))
                    return temp;
                else{
                    return temp + reverse(u);// 4-5. 생성된 문자열을 반환합니다.
                }
            }
        }

        public String solution(String p) {
            return solve(p);
        }
}
