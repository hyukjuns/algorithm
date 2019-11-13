package boj.str; //1032 명령 프롬포트 str
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class Str_1032 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] str = new String[n];
        for(int i=0; i<n; i++){
            str[i] = br.readLine();
        }
        String temp = str[0];
        for(int i=1; i<n; i++){
            StringBuilder res = new StringBuilder();
            for(int j=0; j<temp.length(); j++){
                if(temp.charAt(j) == str[i].charAt(j))
                    res.append(temp.charAt(j));
                else
                    res.append('?');
            }
            temp = res.toString();
        }
        bw.write(temp);
        bw.flush();
        bw.close();
    }
}
