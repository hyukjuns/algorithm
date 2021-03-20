package programmers.kakao_blind_2019;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

//tc 18,19,20,22,25 fail 부분집합 제외 구현 필요
public class sol_2 {
    static int row,col;
    static boolean[] used;
    static ArrayList<String> BeforsuperKeys = new ArrayList<>();
    static ArrayList<String> superKeys = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
        int ans = solution(relation);
        bw.write(ans+"");
        bw.flush();
        bw.close();
    }
    public static int solution(String[][] relation) {
        row = relation.length;
        col = relation[0].length;
        used = new boolean[col];
        for(int i=0; i<col; i++){
            used = new boolean[col];
            dfs("",0,i+1);
        }

        for(int i=0; i<BeforsuperKeys.size(); i++){
            String colNum = BeforsuperKeys.get(i);
            check(relation,colNum);
        }
        // 최소성구하기
        return 1;
    }
    static void check(String[][] relation,String colNum){
        HashSet<String> hs = new HashSet<>();
        for(int i=0; i<row; i++){
            String temp="";
            for(int j=0; j<colNum.length(); j++){
                temp += relation[i][colNum.charAt(j)-'0'];
            }
            hs.add(temp);
        }
        if(hs.size()==row){
            superKeys.add(colNum);
        }
    }
    static void dfs(String order,int next, int max){
        if(order.length()==max){
            BeforsuperKeys.add(order);
            return;
        }
        for(int i=next; i<col; i++){
            if(used[i]==false){
                used[i] = true;
                dfs(order + i,i+1,max);
                used[i] = false;
            }
        }
    }
}
