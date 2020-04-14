package programmers;

import java.util.HashMap;

public class camouflage {
    public static int solution(String[][] clothes) {
       HashMap<String,Integer> clothesMap = new HashMap<>();
       for(String[] s : clothes){
          clothesMap.put(s[1],clothesMap.getOrDefault(s[1],0)+1);
       }
       int sum=1;
       for(int val : clothesMap.values()){
           sum *= (val+1);// 해당 옷 종류를 착용안하는 경우 +1
       }
       return sum-1;//옷을 안입는 경우는 없음 -1
    }
    public static void main(String[] args){
        String[][] clo = {{"yellow_hat","headgear"},{"blue_sunglasses","eyewear"}, {"green_turban","headgear"}};
        System.out.println(solution(clo));
    }
}
