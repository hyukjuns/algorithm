package boj.sort;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Sort_10825 {
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        Info[] student = new Info[n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            student[i] = new Info(name,korean,english,math);
        }
        Arrays.sort(student, new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                if(o2.korean > o1.korean) //국어 내림차순
                    return 1;
                else if(o2.korean == o1.korean){
                    if(o1.english > o2.english) //영어 오름차순
                        return 1;
                    else if(o1.english == o2.english){
                        if(o2.math > o1.math) //수학 내림차순
                            return 1;
                        else if(o2.math == o1.math){
                            if(o1.name.compareTo(o2.name) > 0) //이름 사전순 오름차순
                                return 1;
                            else
                                return -1;
                        }
                        else
                            return -1;
                    }
                    else
                        return -1;
                }
                else
                    return -1;
            }
        });
        for(int i=0; i<n; i++){
            bw.write(student[i].name+"\n");
        }
        bw.flush();
        bw.close();
    }
}
class Info{
    String name;
    int korean;
    int english;
    int math;
    public Info(String name, int korean, int english, int math){
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
    }
}
