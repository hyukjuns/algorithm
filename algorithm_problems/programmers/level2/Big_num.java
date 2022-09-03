package programmers.level2;

import java.io.*;

public class Big_num {
    public static String solution(int[] numbers) {
        String answer = "";

        return answer;
    }
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = {6,10,2};
        String result = solution(nums);
        bw.write(result);
        bw.flush();
        bw.close();
    }
}
