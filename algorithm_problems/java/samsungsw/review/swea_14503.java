package samsungsw.review;
import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.Collections;
import java.util.Arrays;
import java.util.function.BinaryOperator;


public class swea_14503 {
    static int s = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String temp = "0::12:12:34";
        String[] test = temp.split("\\.");
        int target = 5;
        int nmg;
        Stack<Integer> stk  = new Stack<>();
        while(target !=1){
            nmg = target%2;
            target = target/2;
            stk.add(nmg);
        }
        stk.add(target);
        while(!stk.isEmpty()){
            if(stk.pop()==1)
                System.out.println("1");
        }
    }
}
