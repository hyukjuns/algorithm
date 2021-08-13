package boj.str;

import java.io.*;

public class Str_2902 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        String res = String.valueOf(str.charAt(0));
        for(int i=1; i<str.length(); i++){
            if(str.charAt(i) == '-')
                res += String.valueOf(str.charAt(i+1));
        }
        bw.write(res);
        bw.flush();
        bw.close();
    }
}
