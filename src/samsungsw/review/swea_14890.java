package samsungsw.review;

import java.io.*;
import java.util.StringTokenizer;

public class swea_14890 {
    static int n;
    static int l;
    static int[][] map;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans=0;
        for(int i=0; i<map.length; i++){
            ans  += startLine(map[i],l);
        }
        //col to row
        int[][] tempMap = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                tempMap[i][j] = map[j][i];
            }
        }
        for(int i=0; i<tempMap.length; i++){
            ans  += startLine(tempMap[i],l);
        }
        bw.write(ans+"");
        bw.flush();
        bw.close();
    }

    public static int startLine(int[] arr, int l){
        int i=0;
        String dir;
        boolean[] visited = new boolean[arr.length];
        while(i < arr.length-1){
            boolean isOk = true;
            int temp;
            if(arr[i] != arr[i+1]){
                if(arr[i] - arr[i+1] == 1){//left higher than right
                    dir = "left";
                    temp = i+1;
                    for(int k=0; k<l; k++){
                        if(temp+k >= arr.length || arr[temp] != arr[temp+k]){
                            isOk = false;
                            break;
                        }
                        if(visited[temp+k]){
                            isOk = false;
                            break;
                        }
                    }
                }else if(arr[i] - arr[i+1] == -1){//right highr than left
                    dir = "right";
                    temp = i;
                    for(int k=0; k<l; k++){
                        if(temp-k < 0 || arr[temp] != arr[temp-k]){
                            isOk = false;
                            break;
                        }
                        if(visited[temp-k]){
                            isOk = false;
                            break;
                        }
                    }
                }else{ //high is not 1
                    return 0;
                }
                if(isOk){
                    if(dir.equals("left")){
                        for(int k=0; k<l; k++){
                            visited[temp+k] = true;
                        }
                    }
                    else{
                        for(int k=0; k<l; k++){
                            visited[temp-k] = true;
                        }
                    }
                    i++;
                }
                else{
                    return 0;
                }
            }else{
                i++;
            }
        }
//        for(int k : arr)
//            System.out.print(k+" ");
//        System.out.println();
        return 1;
    }
}
