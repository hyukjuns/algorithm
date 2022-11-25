package boj.str; //10808 알파벳 개수 str
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Str_10808  {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int[] res = new int[26];

        for(int i=0; i<str.length(); i++){
            for(int j=0; j<26; j++) {
                if (str.charAt(i) == 'a' + j) //charAt(i)는 char반환,  아래는 charAt(i) - '0'  설명
                    res[j]++;               //숫자CHAR(0~9)는 ASCII코드 48부터 시작하므로, 48('0')을 빼주면 숫자(int) 얻을 수 있다.
            }
        }
        for(int i=0; i<26; i++){
            bw.write(res[i]+" ");
        }
        bw.flush();
        bw.close();
    }
}
