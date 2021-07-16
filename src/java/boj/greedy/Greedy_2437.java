package boj.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Greedy_2437 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums); //오름차순 정렬;
        int target = 0;
        while(true){
            target++;
            int temp = target;
            int i;
            if(nums[0] != 1) //1부터 시작 안하면 1이 최솟값;
                break;
            for(i=0; i<n; i++){
                if(target < nums[i]) //target 보다 큰수 나오면 break
                    break;
            }
            for(int j = i-1; j>=0; j--){ // 큰수 앞에서부터 빼기
                if(temp - nums[j] < 0) // 음수면 해당 무게추 사용 안함
                    continue;
                else
                    temp -= nums[j];
                if(temp == 0) //0 이 되면 만들 수 있는 무게
                    break;
            }
            if(temp > 0) //무게추 모두 소진 했는데 0 이상이면 만들 수 없는 무게
                break;
        }
        bw.write(target+"");
        bw.flush();
        bw.close();
    }
}
