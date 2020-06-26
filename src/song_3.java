import java.util.*;
public class song_3 {
    class Solution {
        public int solution(String[] ip_addrs, String[] langs, int[] scores) {
            int answer = ip_addrs.length;
            ArrayList<String> lanList = new ArrayList<String>();
            ArrayList<String> scoresList = new ArrayList<String>();

            HashMap<String, Node> hm = new HashMap<String, Node>();
            for(int i = 0; i < ip_addrs.length; i++) {
                String str =ip_addrs[i];
                String score = scores[i]+"";
                String lan = langs[i];
                ArrayList<String> newLan = new ArrayList<String>();
                ArrayList<String> newSc = new ArrayList<String>();
                if(hm.containsKey(str)) {
//            hm.put(str, new Node(hm.get(str).lang.add(lan), hm.get(str).score.add(score), hm.get(str).count+1);
                    for (String string : hm.get(str).score) {
                        newSc.add(string);
                    }

                    for (String string : hm.get(str).lang) {
                        newLan.add(string);
                    }
                    if(lan.equals("C#") || lan.equals("C++")) lan = "C";
                    newLan.add(lan);
                    newSc.add(score);

                    scoresList.add(score);
                    hm.put(str, new Node(newLan,newSc, hm.get(str).count+1));
                }else {
                    if(lan.equals("C#") || lan.equals("C++")) lan = "C";
                    newLan.add(lan);
                    newSc.add(score);
                    hm.put(str, new Node(new ArrayList<String>(), new ArrayList<String>(), 1));
                    hm.put(str, new Node(newLan, newSc, 1));


                }
            }

            for(HashMap.Entry<String, Node> entry : hm.entrySet()) {
                System.out.println(entry.toString());
                if(entry.getValue().count == 2) {
                    String num = entry.getValue().score.get(0);
                    if(num.equals(entry.getValue().score.get(1))) {
                        //언어도 같은지 봐야됨
                        String lan = entry.getValue().lang.get(0);
                        String lan1 = entry.getValue().lang.get(1);
                        if(lan.equals(lan1)) answer-=2;
                    }
                }else if(entry.getValue().count == 3) {
                    String lan = entry.getValue().lang.get(0);
                    String lan1 = entry.getValue().lang.get(1);
                    String lan2= entry.getValue().lang.get(2);
                    if(lan.equals(lan1) && lan1.equals(lan2)) answer -=3;
                }else if(entry.getValue().count >= 4) {
                    answer -= entry.getValue().count;
                }
            }

            return answer;
        }
        class Node{
            ArrayList<String> lang;
            ArrayList<String> score;
            int count;
            public Node(ArrayList<String> lang, ArrayList<String> score, int count) {
                super();
                this.lang = lang;
                this.score = score;
                this.count = count;
            }
            @Override
            public String toString() {
                return "Node [lang=" + lang + ", score=" + score + ", count=" + count + "]";
            }

        }
    }
}
