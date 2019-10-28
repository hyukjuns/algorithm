package boj.data_structure;//7785 회사에 있는 사람 data_structure

import java.io.*;
import java.util.*;

public class DataStructure_7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());
        String[][] record = new String[n][2];
        for(int i =0 ; i<n; i++){
            st = new StringTokenizer(br.readLine());
            record[i][0] = st.nextToken();
            record[i][1] = st.nextToken();
        }
        HashSet<String> idSet = new HashSet<>();
        for(int i=0; i<n; i++){
            if(record[i][1].equals("enter")){
                idSet.add(record[i][0]);
            }
            else if(record[i][1].equals("leave")){
                idSet.remove(record[i][0]);
            }
        }
        ArrayList<String> temp = new ArrayList<>(idSet);
        temp.sort(Comparator.reverseOrder());
        for(int i=0; i<temp.size(); i++){
            bw.write(temp.get(i)+"\n");
        }
        bw.flush();
        bw.close();

    }
}
