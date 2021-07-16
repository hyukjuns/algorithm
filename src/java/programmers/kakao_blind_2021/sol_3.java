package programmers.kakao_blind_2021;

import javax.print.DocFlavor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class sol_3 {
    public static void main(String[] args) throws IOException{
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        int[] ans = solution(info, query);
        for(int i : ans){
            System.out.println(i);
        }
    }
    public static int[] solution(String[] info, String[] query) {
        int[] ans = new int[query.length];

        ArrayList<Info2> alist = new ArrayList<>();
        HashMap<String, Integer>[] hm = new HashMap[info.length];
        int id=0;
        for(String infoStr : info){
            String[] arr = infoStr.split(" ");
            hm[id] = new HashMap<>();
            for(int i=0; i<arr.length; i++){
                hm[id].put(arr[i],id);
            }
            hm[id].put("-",id);
            alist.add(new Info2(id, Integer.parseInt(arr[arr.length-1])));
            id++;
        }

        int idx=0;
        for(String str : query){
            int cnt=0;
            str = str.replaceAll("and","");
            StringTokenizer st = new StringTokenizer(str);
            String lang = st.nextToken();
            String role = st.nextToken();
            String career = st.nextToken();
            String food = st.nextToken();
            int score = Integer.parseInt(st.nextToken());
            System.out.println(lang+" "+role+" "+career+" "+food+" "+score);
            ans[idx++] = cnt;
        }
        return ans;
    }
}
class Info2{
    int idx;
    int score;
    public Info2(int idx, int score){
        this.idx=idx;
        this.score=score;
    }
}
