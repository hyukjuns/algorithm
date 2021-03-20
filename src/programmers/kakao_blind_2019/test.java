package programmers.kakao_blind_2019;

import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException{
        String test1 = "bc";
        String test2 = "bcd";
        String test3 = "bed";
        if(test2.contains(test1)){
            System.out.println(test2);
        }else if(test3.contains(test1)){
            System.out.println(test1);
        }
    }
}
