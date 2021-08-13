package programmers;

import javax.swing.*;
import java.io.*;
import java.util.*;

public class Kakao_installOfstructure {


    static int[][] solution(int n, int[][] build_frame){
        int[][] ans = {};
        return ans;
    }
    public static void main(String[] args) throws IOException{
        int n = 5;
        int[][] build_frame = {{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}};

    }
    static void print(int[][] ans){
        for(int i=0; i<ans.length; i++){
            System.out.println(ans[i][0]+" "+ans[i][1]+" "+ans[i][2]);
        }
    }
}
class frameInfo{
    int x;
    int y;
    int frame;
    public frameInfo(int x, int y, int frame){
        this.y=y;
        this.x=x;
        this.frame=frame;
    }
}
