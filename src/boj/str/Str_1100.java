package boj.str;

import java.io.*;

public class Str_1100 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt=0;
        for(int i=0; i<8; i++){
            String str = br.readLine();
            if(i%2 == 0){//흰 검
                for(int k=0; k<8; k+=2){
                    if(str.charAt(k) == 'F')
                        cnt++;
                }
            }
            else{
                for(int k=1; k<8; k+=2)
                    if(str.charAt(k) == 'F')
                        cnt++;
            }
        }
        bw.write(cnt+"");
        bw.flush();
        bw.close();
    }
}
