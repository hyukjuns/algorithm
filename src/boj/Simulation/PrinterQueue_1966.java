package boj.Simulation;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class PrinterQueue_1966 {
    static int tc, n, m;
    static ArrayList<PaperInfo> papers;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        tc = Integer.parseInt(br.readLine());
        for(int i=0; i<tc; i++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            papers = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                papers.add(new PaperInfo(j, Integer.parseInt(st.nextToken())));
            }
            int result = solution();
            bw.write(result+"\n");
        }
        bw.flush();
        bw.close();
    }
    public static int solution(){
        int max = getMaxValue();
        int output=-1;
        int count=0;
        while(true){
            if(output == m) break;
            PaperInfo first = papers.remove(0);
            if(first.weight < max){
                papers.add(new PaperInfo(first.index,first.weight));
            }else{
                output = first.index;
                max = getMaxValue();
                count++;
            }

        }
        return count;
    }
    public static int getMaxValue(){
        int max=Integer.MIN_VALUE;
        for(int i=0; i<papers.size(); i++){
            int cur = papers.get(i).weight;
            if(max < cur)
                max = cur;
        }
        return max;
    }
}
class PaperInfo{
    int index;
    int weight;
    public PaperInfo(int index, int weight){
        this.index=index;
        this.weight=weight;
    }
}
