package boj.tree;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Tree_1539 {
    static int[] heights;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        heights = new int[n];
        list = new ArrayList<>();
        long sum=0;
        for(int i=0; i<n; i++){
            sum += getHeight(Integer.parseInt(br.readLine()));
        }
        bw.write(sum+"");
        bw.flush();
        bw.close();
    }
    public static int getHeight(int node){
        int lb,left,right, size = list.size();
        lb = lower_bound(list, node, size);
        left = lb>0 ? heights[list.get(lb-1)] : 0;
        right = lb<size ? heights[list.get(lb)] : 0;

        heights[node] = Math.max(left,right)+1;
        list.add(lb,node);

        return heights[node];
    }
    public static int lower_bound(List<Integer> array, int target, int size){
        int mid, start, end;
        start = 0;
        end = size;
        while(end > start){
            mid = (start + end) / 2;
            if(array.get(mid) >= target){
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        return end;
    }

}

