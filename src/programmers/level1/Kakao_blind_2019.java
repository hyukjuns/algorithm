package programmers.level1;

import java.io.*;
import java.util.*;

public class Kakao_blind_2019 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = 8;
        int[] stages = new int[] {1,2,3,4,5,6,7};
        int[] ans = solution(n,stages);
        for(int i=0; i<ans.length; i++){
            System.out.print(ans[i]+" ");
        }
    }
    public static int[] solution(int N, int[] stages) {
        int[] ans = new int[N];
        if(N==1) {
            ans[0] = 1;
            return ans;
        }
        long[] stage_1 = new long[N+1];
        long[] stage_2 = new long[N+1];

        for(int i=0; i<stages.length; i++){
            if(stages[i]==N+1)  continue;
            stage_1[stages[i]]++;
        }
        for(int i = 1; i<=N; i++){
            System.out.print(stage_1[i]);
        }
        System.out.println();

        stage_2[1] = stages.length;
        for(int i=2; i<=N; i++){
            stage_2[i] = stage_2[i-1] - stage_1[i-1];
        }
        for(int i = 1; i<=N; i++){
            System.out.print(stage_2[i]);
        }

        ArrayList<Infolist> list = new ArrayList<>();
        for(int i=1; i<=N; i++){
            double failure;
            if(stage_2[i] == 0) {
                if(stage_1[i]==0)
                    failure = 0;
                else
                    failure = 1;
            }
            else
                failure = (double)stage_1[i]/stage_2[i];
            list.add(new Infolist(i, failure));
        }
        Collections.sort(list, new Comparator<Infolist>() {
            @Override
            public int compare(Infolist o1, Infolist o2) {
                if(o1.rate < o2.rate){
                    return 1;
                }
                else if(o1.rate == o2.rate){
                    if(o1.idx > o2.idx){
                        return 1;
                    }
                }
                return -1;
            }
        });
        for(int i=0; i<N; i++){
            ans[i] = list.get(i).idx;
        }
        return ans;
    }
}
class Infolist {
    int idx;
    double rate;
    public Infolist(int idx, double rate){
        this.idx=idx;
        this.rate=rate;
    }
}