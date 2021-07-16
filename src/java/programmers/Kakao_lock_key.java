package programmers;

class Kakao_lock_key {
    static int oglockLen;
    static int[][] broadenLock;
    static boolean answer=false;

    public static void backUpArr(int[][] target){

        for(int i=0; i<broadenLock.length; i++){
            for(int j=0; j<broadenLock.length; j++){
                target[i][j] = broadenLock[i][j];
            }
        }

    }
    public static void solve(int[][] key){

        int[][] b_lock = new int[broadenLock.length][broadenLock.length];
        backUpArr(b_lock);
        int b_lockLen = b_lock.length;
        int keyLen = key.length;
        for(int i=0; i<=b_lockLen-keyLen; i++){
            for(int j=0; j<=b_lockLen-keyLen; j++){
                //key+lock
                boolean flag = false;
                for(int k=0; k<keyLen; k++){
                    for(int m=0; m<keyLen; m++){
                        //key와 가운데 lock이 겹쳤는지
                        if(k+i >= oglockLen && k+i <oglockLen*2
                                && m+j >= oglockLen && m+j <oglockLen*2){
                            flag = true;
                        }
                        b_lock[k+i][m+j] += key[k][m];
                    }
                }
                //겹쳤으면 자물쇠 풀어졌는지 검사
                if(flag == true && isUnlock(b_lock) == true){
                    answer = true;
                    return;
                }
                backUpArr(b_lock);//초기화
            }
        }
        answer = false;// 자물쇠 못연다

    }

    public static boolean isUnlock(int[][] b_lock){

        for(int i=0; i<oglockLen; i++){
            for(int j=0; j<oglockLen; j++){
                //가운데 자물쇠 영역이
                //2면 돌기+돌기, 0이면 홈
                // 모두 1이어야 잠금해제
                if(b_lock[oglockLen+i][oglockLen+j] == 2 ||
                        b_lock[oglockLen+i][oglockLen+j] == 0){
                    return false;
                }
            }
        }
        return true;

    }
    public static int[][] lotateKey(int[][] key){

        int len = key.length;
        int[][] lotated = new int[len][len];
        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                lotated[i][len-1-j] = key[j][i];
            }
        }
        return lotated;

    }
    public boolean solution(int[][] key, int[][] lock) {

        oglockLen = lock.length;
        broadenLock = new int[oglockLen*3][oglockLen*3];
        for(int i=0; i<oglockLen; i++){
            for(int j=0; j<oglockLen; j++){
                //넓어진 lock가운데로 진짜 자물쇠 옮기기
                broadenLock[oglockLen+i][oglockLen+j] = lock[i][j];
            }
        }
        for(int i=0; i<4; i++){
            key = lotateKey(key);//어차피 마지막에 원본
            solve(key);
            if(answer == true)
                break;
        }
        return answer;

    }
}