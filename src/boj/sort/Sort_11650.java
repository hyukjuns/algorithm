package boj.sort;
import java.io.*;
import java.util.*;
public class Sort_11650 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        int[][] arr = new int[tc][2];
        for(int i=0; i<tc; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, new Comparator<int []>() {
            public int compare(int a[], int b[]) {
                if(a[0]==b[0]) return Integer.compare(a[1], b[1]);
                else return Integer.compare(a[0],b[0]);
            }
        });
        for(int i=0; i<tc; i++) {
            bw.write(arr[i][0]+" "+arr[i][1]+"\n");
        }
        bw.flush();
        bw.close();
    }
}
