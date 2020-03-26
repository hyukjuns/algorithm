package boj.LCS;

import java.io.*;

public class Lcs_9252 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str1 = "0"+br.readLine();
        String str2 = "0"+br.readLine();
        int[][] lcs = new int[str2.length()][str1.length()];
        String[][] dir = new String[str2.length()][str1.length()];
        int len=0;

        //길이 구하기
        for(int i=1; i<str2.length(); i++){
            for(int j=1; j<str1.length(); j++){
                if(str2.charAt(i)==str1.charAt(j)){//같은 문자면 왼쬑 위 대각선 길이 + 1
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                    dir[i][j] = "diagonal";
                }
                else{
                    lcs[i][j] = Math.max(lcs[i][j-1],lcs[i-1][j]); //다른 문자면 왼쪽 혹은 위 쪽 길이 중 큰값
                    if(lcs[i][j]==lcs[i][j-1]){
                        dir[i][j] = "left";
                    }
                    else{
                        dir[i][j] = "up";
                    }
                }
                if(len < lcs[i][j])
                    len = lcs[i][j];
            }
        }

        //lcs 문자열 구하기
        int i = str2.length()-1;
        int j = str1.length()-1;
        StringBuilder ans = new StringBuilder();
        while(dir[i][j] != null){
            if(dir[i][j]=="diagonal"){// 대각선 이면 lcs문자열에 추가
                ans.append(str1.charAt(j));
                i--;
                j--;
            }
            else{
                if(dir[i][j]=="left"){//왼쪽으로 이동
                    j--;
                }
                else{//위쪽으로 이동
                    i--;
                }
            }
        }
        if(len==0) {
            bw.write(len + "");
            bw.flush();
            bw.close();
        }
        else{
            ans = ans.reverse();
            bw.write(len + "\n");
            bw.write(ans.toString());
            bw.flush();
            bw.close();
        }
    }
}
