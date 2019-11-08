package boj.sort;


import java.io.*;
import java.util.*;

public class Sort_11004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<Integer> arr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(arr);
        bw.write(arr.get(k-1)+"");
        bw.flush();
        bw.close();

    }
}
