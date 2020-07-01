package boj.bruteforce;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Brute_2503 {
    static boolean[] nums = new boolean[1000];
    static Queue<Hint> hints = new LinkedList<>();

    public static void initNums(){
        String temp;
        for(int i=123; i<=999; i++){
            temp = String.valueOf(i);
            if(temp.charAt(0) == temp.charAt(1) || temp.charAt(1) == temp.charAt(2) || temp.charAt(0) == temp.charAt(2))    continue;
            if(temp.charAt(0) =='0' || temp.charAt(1) =='0' || temp.charAt(2) =='0') continue;
            nums[i] = true;
        }
    }
    public static int solution(){
        while (!hints.isEmpty()) {
            Hint target = hints.poll();
            String target_val = String.valueOf(target.value);
            for(int i=123; i<=999; i++) {
                int strikes=0;
                int balls=0;
                if(!nums[i])    continue;
                String candi = String.valueOf(i);
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        if(target_val.charAt(j)==candi.charAt(k)){
                            if(j==k)    strikes++;
                            else if(j!=k)   balls++;
                        }
                    }
                }
                if(target.strike != strikes || target.ball != balls)    nums[i] = false;
            }
        }
        int ret=0;
        for(int i=123; i<=999; i++){
            if(nums[i]) ret++;
        }
        return ret;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        int v, s, b;
        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            hints.add(new Hint(v, s, b));
        }
        initNums();
        int result = solution();
        bw.write(result+"");
        bw.flush();
        bw.close();
    }
}
class Hint{
    int value;
    int strike;
    int ball;
    public Hint(int value, int strike, int ball){
        this.value=value;
        this.strike=strike;
        this.ball=ball;
    }
}
