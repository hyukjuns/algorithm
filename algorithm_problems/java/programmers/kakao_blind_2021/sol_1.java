package programmers.kakao_blind_2021;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class sol_1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = ".asdg.";
        bw.write(solution(input));
        bw.flush();
        bw.close();
    }
    public static String solution(String new_id) {
        new_id = new_id.toLowerCase();//1단계

        StringBuffer og = new StringBuffer(new_id);
        //Queue<Integer> removeIdx = new LinkedList<>();
        for(int i=0; i<og.length(); i++){
            char target = og.charAt(i);
            if(target>=97 && target <= 122) continue;
            if(target >= 48 && target <= 57)    continue;
            if(target == 45 || target == 95 || target == 46)    continue;
            //removeIdx.add(i);
            og.replace(i,i+1," ");
        }


//        while (!removeIdx.isEmpty()){
//            int idx = removeIdx.poll();
//            og.replace(idx,idx+1," ");
//        }
        new_id=og.toString().replaceAll(" ","");//2단계

        while(true){
            if(new_id.contains("..")) {
                new_id = new_id.replace("..",".");
            }
            else{
                break;
            }
        }//3단계

        og = new StringBuffer(new_id);
        if(og.length() > 0 && og.charAt(0) == '.'){
            og.deleteCharAt(0);
        }
        if(og.length() > 0 && og.charAt(og.length()-1)=='.'){
            og.deleteCharAt(og.length()-1);
        }//4단계

        if(og.length() == 0 && og.toString().equals(""))   og.append("a"); //5

        if(og.length() >= 16){
            og.delete(15,og.length());
        }
        if(og.length() > 0 && og.charAt(og.length()-1)=='.')   og.deleteCharAt(og.length()-1);//6

        if(og.length()<=2 && og.length() > 0){
            char temp = og.charAt(og.length()-1);
            while(og.length() != 3){
                og.append(temp);
            }
        }//7
        new_id =  og.toString();
        return new_id;
    }
}
