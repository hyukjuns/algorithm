package programmers;

import java.util.HashMap;
import java.util.HashSet;

public class Kakao_candidate_key {
    static int columnLen;
    static String minimalOrder="";
    static int cnt=0;
    static boolean isMinimal;


    static void dfs2(int max, String str, String order, int idx,String[][] relation){
        if(max == str.length()){
            //키를 쪼갯는데 유일성을 만족하면 => 최소성을 만족하지 않게됨
            //즉 키를 쪼갯으면 유일성을 만족하지 않아야 한다.
            if(uniquenessCheck(str,relation)){
                isMinimal = false;
            }
            return;
        }
        for(int i=idx; i<order.length(); i++){
            dfs2(max, str+(order.charAt(i)-'0'), order,i+1,relation);
        }
    }
    static void minimalityCheck(String order,String[][] relation){
        int len = order.length();
        isMinimal = true;
        for(int i=1; i<len; i++){
            dfs2(i, "", order,0,relation);
        }
        if(isMinimal){
            cnt++;
        }
    }
    static boolean uniquenessCheck(String order,String[][] relation){
        char[] colNum = order.toCharArray();
        String[] candiKey = new String[relation.length];
        //key 생성
        for(int i=0; i<relation.length; i++){
            for(int j=0; j<colNum.length; j++){
                candiKey[i] += relation[i][colNum[j]-'0'];
            }
        }
        //유일성 체크
        //HashSet은 중복을 허용하지 않는다.
        HashSet<String> hs = new HashSet<>();
        for(int i=0; i<candiKey.length; i++){
            if(!hs.add(candiKey[i])){
                return false;
            }
        }
        return true;
    }
    static void dfs(int max, String str, int idx, String[][] relation){
        if(str.length()==max){
            //유일성 만족 못하면 패스
            if(!uniquenessCheck(str,relation)){
                return;
            }
            minimalityCheck(str,relation);
            return;
        }
        for(int i=idx; i<columnLen; i++){
            dfs(max, str+i, i+1,relation);
        }
    }
    static int solution(String[][] relation){
        columnLen = relation[0].length;
        //후보키 조합 찾기
        for(int i=1; i<=columnLen; i++){
            dfs(i, "",0,relation);
        }
        return cnt;
    }
    public static void main(String[] args){
        String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
        System.out.println(solution(relation));
    }
}
