import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class solution3 {
    static ArrayList<Integer> holeList = new ArrayList<>();
    static Stack<Integer> fixSpot = new Stack<>();
    static int maxRoad = Integer.MIN_VALUE;

    static void check(String road){
        int[] fixArea = new int[fixSpot.size()];
        for(int i=0; i<fixArea.length; i++){
            fixArea[i] = fixSpot.get(i);
        }
        StringBuilder sb = new StringBuilder(road);
        for(int i=0; i<fixArea.length; i++){
            int start  = fixArea[i];
            int end  = fixArea[i]+1;
            sb.replace(start,end,"1");
        }
        String fixedRoad = sb.toString();
        System.out.println(fixedRoad);
        int cnt=0;
        boolean counted = false;
        for(int i=0; i<fixedRoad.length(); i++){
            if(fixedRoad.charAt(i)=='1'){
                counted = false;
                cnt++;
            }
            else if(fixedRoad.charAt(i)=='0'){
                maxRoad = Math.max(maxRoad,cnt);
                counted = true;
                cnt=0;
            }
        }
        if(!counted){
            maxRoad = Math.max(maxRoad,cnt);
        }

    }
    static void dfs(int max, int idx, int cnt, String road){
        if(max == cnt){
            check(road);
            System.out.println(fixSpot);
            return;
        }
        for(int i=idx; i<holeList.size(); i++){
            fixSpot.add(holeList.get(i));
            dfs(max, i+1, cnt+1,road);
            fixSpot.pop();
        }

    }
    static int solution(String road, int n) {
        for(int i=0; i<road.length(); i++){
            if(road.charAt(i)=='0'){
                holeList.add(i);
            }
        }
        int max=0;
        if(holeList.size()<n){
            max = holeList.size();
        }
        else{
            max = n;
        }
        dfs(max, 0,0,road);
        return maxRoad;

    }
    public static void main(String[] args) {
        System.out.println(solution("1011111"	,2));
    }

}
