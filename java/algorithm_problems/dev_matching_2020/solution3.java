package dev_matching_2020;

public class solution3 {
    static int min = Integer.MAX_VALUE;
    static boolean[] used;

    public static void swap(int[] array, int a, int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
    public static boolean isUnder(int[] array,int k){
        for(int i=0; i<array.length-1; i++){
            if(Math.abs(array[i]-array[i+1]) > k)
                return false;
        }
        return true;
    }
    public static void copyArr(int[] a, int[] b){
        for(int i=0; i<a.length; i++){
            b[i] = a[i];
        }
    }
    public static void dfs(int[] prev, int k, int val, String swaps){
        int[] current = new int[prev.length];
        copyArr(prev,current);
        if(swaps.length() != 0 && swaps.length() % 2 == 0){
            int a = swaps.charAt(swaps.length()-2)-'0';
            int b = swaps.charAt(swaps.length()-1)-'0';
            swap(current,a,b);
            if(isUnder(current,k)){
                if(val==0)
                    min = 0;
                else
                    min = Math.min(min,val/2);
                return;
            }
        }
        for(int i=0; i<prev.length; i++){
            if(!used[i]) {
                used[i]=true;
                dfs(current, k, val + 1, swaps + i);
                used[i]=false;
            }
        }

    }
    public static int solution(int[] numbers, int K) {
        used = new boolean[numbers.length];
        dfs(numbers,K,0,"");
        int answer = min;
        if(numbers.length==1)
            answer = 0;
        if(answer == Integer.MAX_VALUE)
            answer = -1;
        return answer;
    }
    public static void main(String[] args) {
        int[] numbers = {10};
        int k = 20;
        System.out.println(solution(numbers,k));
    }
}
