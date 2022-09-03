package samsungsw.review;

import java.io.*;
import java.util.StringTokenizer;

public class swea_13458 {
    static long n;
    static long[] arr;
    static long commanderSite;
    static long subCommanderSite;
    static long total=0;
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Long.parseLong(br.readLine());
        arr = new long[(int)n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        commanderSite = Long.parseLong(st.nextToken());
        subCommanderSite = Long.parseLong(st.nextToken());

        total += n;
        for(int i=0; i<n; i++){
            if(arr[i] <= commanderSite) arr[i]=0;
            else    arr[i] -= commanderSite;
        }

        long mok,nmg;
        for(int i=0; i<n; i++){
            if(arr[i]==0)   continue;
            mok = arr[i] / subCommanderSite;
            nmg = arr[i] % subCommanderSite;
            if(mok == 0){
                if(arr[i] < subCommanderSite)   nmg = 1;
            }else{
                if(subCommanderSite == 1){
                    total += mok;
                    continue;
                }
                if(arr[i] != subCommanderSite && nmg < subCommanderSite && nmg != 0)  nmg = 1;
            }
            total += (mok+nmg);
        }
        bw.write(total+"");
        bw.flush();
        bw.close();
    }
}
