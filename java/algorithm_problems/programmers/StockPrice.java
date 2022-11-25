package programmers;

public class StockPrice {
    public static int[] solution(int[] prices) {
        int[] ans  = new int[prices.length];
        for(int i=0; i<prices.length; i++){
            int cnt=0;
            for(int j=i+1; j<prices.length; j++){
                if(prices[i] <= prices[j]){
                    cnt++;
                }else{
                    cnt++;
                    break;
                }
            }
            ans[i] = cnt;
        }
        return ans;

    }
    public static void main(String[] args) {
        int[] prices = {1,2,3,2,3};
        int[] ans = solution(prices);
        for(int i: ans){
            System.out.print(i+" ");
        }

    }
}

