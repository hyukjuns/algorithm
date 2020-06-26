package programmers.level2;

public class Joy_Stick {
    public static int solution(String name) {
        int answer=0;
        //1. 커서 좌우 이동 최소화
        String origin = "";
        for(int i=0; i<name.length(); i++){
            origin += "A";
        }

        boolean flag = false;
        int idx=0;
        for(int i=0; i<name.length(); i++){
            if(name.charAt(i)=='A') {
                flag = true;
                idx = i;
                break;
            }
        }

        boolean temp=false;
        if(flag){
            for(int i=idx+1; i<name.length(); i++){
                if(name.charAt(i) == 'A')
                    continue;
                else {
                    temp = true;
                    break;
                }
            }
        }

        //정방향 한번
        int sum=0;
        int cnt=0;
        for(int i=0; i<name.length(); i++){
            char target = origin.charAt(i);
            if(target==name.charAt(i) && temp == false)
                break;
            int up=0;
            while(target != name.charAt(i)){
                up++;
                target++;
            }

            target = 'Z';
            int down=1;
            while(target != name.charAt(i)){
                down++;
                target--;
            }

            sum += Math.min(up,down);
            cnt++;
        }
        sum += (cnt-1);
        //역방향 한번
        int sum2=0;
        if(flag) {
            for (int i = 0; i < idx; i++) {
                char target = origin.charAt(i);
                int up = 0;
                while (target != name.charAt(i)) {
                    up++;
                    target++;
                }
                target = 'Z';
                int down = 1;
                while (target != name.charAt(i)) {
                    down++;
                    target--;
                }

                sum2 += Math.min(up, down);
            }
            sum2 += ((idx - 1) * 2);
            boolean isDiff=false;
            int index2=0;
            for(int i=idx+1; i<name.length(); i++){
                char target = origin.charAt(i);
                if(target == name.charAt(i)){
                    continue;
                }else{
                    index2=i;
                    isDiff = true;
                    break;
                }
            }
            if(isDiff == true) {
                sum2 += 1;
                int reverse = -1;
                for (int i = name.length() - 1; i >= index2; i--) {
                    char target = origin.charAt(i);
                    int up = 0;
                    while (target != name.charAt(i)) {
                        up++;
                        target++;
                    }

                    target = 'Z';
                    int down = 1;
                    while (target != name.charAt(i)) {
                        down++;
                        target--;
                    }
                    sum2 += Math.min(up, down);
                    reverse++;
                }
                sum2 += reverse;
            }
        }

        if(flag){
            if(sum==sum2){
                answer = sum2;
            }else{
                answer = Math.min(sum,sum2);
            }
        }else{
            answer = sum;
        }
        return answer;
    }
    public static void main(String[] args) {
        String name = "BBAABAA";
        System.out.println(solution(name));
    }
}
//A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
