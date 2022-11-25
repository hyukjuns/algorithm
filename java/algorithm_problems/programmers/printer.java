package programmers;

import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;

public class printer {

    public static int solution(int[] priorities, int location) {
        int ans = 0;
        Deque<Info> dq = new LinkedList<>();
        int idx=0;
        for(int p : priorities){
            dq.add(new Info(p,idx));
            idx++;
        }
        boolean flag;
        idx=0;
        while(!dq.isEmpty()){
            flag = false;
            Info temp = dq.poll();
            for(Info in : dq){
                if(temp.pri < in.pri){
                    flag = true;
                    dq.addLast(temp);
                    break;
                }
            }
            if(!flag){
                idx++;
                if(temp.idx == location){
                    ans = idx;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        int[] pri = {1,1,9,1,1,1};
        int loc = 0;
        System.out.println(solution(pri, loc));
    }
}
class Info{
    int pri;
    int idx;
    public Info(int pri, int idx){
        this.pri = pri;
        this.idx = idx;
    }
}

