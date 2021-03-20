package programmers.kakao_blind_2021;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class sol_2 {
    static char[] foods;
    static boolean[] used;
    static ArrayList<Info> arr;
    public static void main(String[] args) throws IOException {
        String[] orders = {"GED","YTR","BCD","DSA","SA","QWERTYUIOP"};
        int[] course = {2,3,5};
        String[] ans = solution(orders,course);
        for(int i=0; i<ans.length; i++){
            System.out.println(ans[i]);
        }
       ArrayList<Integer> test = new ArrayList<>();
        String[] test2 = new String[test.size()];
       //System.out.println(test.get(0));
    }

    public static String[] solution(String[] orders, int[] course) {
        ArrayList<String> ans = new ArrayList<>();
        HashSet<Character> list = new HashSet<>();
        for(int i=0; i<orders.length; i++){
            for(int j=0; j<orders[i].length(); j++){
                list.add(orders[i].charAt(j));
            }
        }
        foods = new char[list.size()];
        //used = new boolean[list.size()];
        int idx = 0;
        for(char c : list){
            foods[idx] = c;
            idx++;
        }

        for(int i=0; i<course.length; i++){
            int num = course[i];
            used = new boolean[list.size()];
            arr = new ArrayList<>();
            dfs("",0,num,orders); //음식들 조합시작
            if(!arr.isEmpty()) {
                Collections.sort(arr, new Comparator<Info>() {
                    @Override
                    public int compare(Info o1, Info o2) {
                        if (o1.cnt < o2.cnt) {
                            return 1;
                        } else
                            return -1;
                    }
                });

                for (int k = 0; k < arr.size(); k++) {
                    if (arr.get(0).cnt == arr.get(k).cnt) {
                        ans.add(arr.get(k).order);
                    }
                }
            }
        }
        String[] listOfans = new String[ans.size()];
        if(!ans.isEmpty()) {
            Collections.sort(ans);
            for (int i = 0; i < listOfans.length; i++) {
                listOfans[i] = ans.get(i);
            }
        }
        return listOfans;
    }
    public static void dfs(String combo, int next, int max,String[] orders){
        if(combo.length() == max){
            int count = countOfOrder(orders,combo,max);
            if(count >= 2){
                arr.add(new Info(combo,count));
            }
            return;
        }
        for(int i=next; i<foods.length; i++){
            if(!used[i]){
                used[i] = true;
                dfs(combo+foods[i],i+1, max,orders);
                used[i] = false;
            }
        }
    }
    public static int countOfOrder(String[] orders, String combo, int num){
        char[] sole = new char[num];
        for(int i=0; i<num; i++){
            sole[i] = combo.charAt(i);
        }

        int cnt=0;
        for(int i=0; i<orders.length; i++) {
            boolean flag =  true;
            for(int k=0; k<sole.length; k++){
                if(orders[i].indexOf(sole[k]) != -1)    continue;
                flag=false;
            }
            if(flag)
                cnt++;
        }
        return cnt;
    }
}
class Info{
    String order;
    int cnt;
    public Info(String order, int cnt){
        this.order=order;
        this.cnt=cnt;
    }
}
