package programmers;

import java.io.IOException;

public class rectangle {
    private static long gcd(long w, long h){
        long a, b;
        if(w>=h){
            a=w;
            b=h;
        }else{
            a=h;
            b=w;
        }
        while(b!=0){
            long r = a%b;
            a = b;
            b = r;
        }
        return a;
    }
    public static long solution(int w,int h) {
        long lw = Long.parseLong(String.valueOf(w));
        long lh = Long.parseLong(String.valueOf(h));

        return lw*lh - (lw+lh-gcd(lw,lh));
    }
    public static void main(String[] args) throws IOException {
        System.out.println(solution(8,12));
    }

}
