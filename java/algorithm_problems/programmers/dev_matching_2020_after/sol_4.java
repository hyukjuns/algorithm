package programmers.dev_matching_2020_after;

import java.lang.reflect.Array;
import java.rmi.AlreadyBoundException;
import java.util.*;

public class sol_4 {
    public static void main(String[] args){
        String[]  str = {"AAD", "AAA", "AAC", "AAB"};
        System.out.println(solution(str,4));
    }
    public static String solution(String[] votes, int k) {
        HashMap<String,Integer> hm = new HashMap<>();
        for(int i=0; i<votes.length; i++){
            if(hm.containsKey(votes[i])){
                hm.put(votes[i],hm.get(votes[i])+1);
            }else{
                hm.put(votes[i],1);
            }
        }

        ArrayList<Info> alist = new ArrayList<>();
        for(String temp : hm.keySet()){
            alist.add(new Info(temp, hm.get(temp)));
        }
        Collections.sort(alist, new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                if(o1.rank < o2.rank){
                    return 1;
                }else if(o1.rank == o2.rank){
                    if(o1.name.compareTo(o2.name) >= 1){
                        return 1;
                    }else
                        return -1;
                }
                return -1;
            }
        });
//        for(Info temp : alist){
//            System.out.println(temp.name +" "+temp.rank);
//        }
        int total=0;
        for(int i=0; i<k; i++){
            total += alist.get(i).rank;
        }
        //System.out.println(total);
        String ans="";
        int ftotal=0;
        for(int i=alist.size()-1; i>=0; i--){
            ftotal += alist.get(i).rank;
            if(total <= ftotal){
                ftotal -= alist.get(i).rank;
                ans = alist.get(i+1).name;
                break;
            }
        }
        return ans;
    }
}
class Info{
    String name;
    int rank;
    public Info(String name, int rank){
        this.name=name;
        this.rank=rank;
    }
}
