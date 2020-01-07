package boj.str;

import java.io.*;
import java.util.*;

public class Str_1764 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<String> noHear = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();
        for(int i=0; i<n; i++){
            noHear.add(br.readLine());
        }
        Collections.sort(noHear);
        for(int i=0; i<m; i++){
            String str = br.readLine();
            int res = Collections.binarySearch(noHear,str);
            if(res >=0)
                result.add(str);
        }

        bw.write(result.size()+"\n");
        Collections.sort(result);
        Iterator itr = result.iterator();
        while(itr.hasNext()){
            bw.write(itr.next().toString()+"\n");
        }
        bw.flush();
        bw.close();
    }
}
