package boj.greedy;//2875 대회 or 인턴 greedy
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Greedy_2875 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //여학생 수
        int m = Integer.parseInt(st.nextToken());//남학생 수
        int k = Integer.parseInt(st.nextToken());//인턴쉽 참가자 수
        int res=0;

        int n_k=k;
        int m_k=0;
        int teamCnt=0;
        int tempn = n;
        int tempm = m;
        while(!(n_k < 0)){
            teamCnt=0;
            tempn -= n_k; // 인턴 수 만큼 빼주기
            tempm -= m_k;
            while(!(tempn<2 || tempm<1)){
                tempn -= 2;
                tempm -= 1;
                teamCnt++;
            }
            if(res < teamCnt)
                res = teamCnt;
            n_k--;
            m_k++;
            tempn = n;
            tempm = m;
        }
        bw.write(res+"");
        bw.flush();
        bw.close();

    }
}
