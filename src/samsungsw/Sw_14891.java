package samsungsw;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Sw_14891 {
    static LinkedList<Integer>[] gear  = new LinkedList[5];
    static int[][] opcode;
    static boolean[] move = new boolean[5];
    static int[] dir = new int[5];
    static int k;
    public static void currentCheck(int target){
        move[target] = true;
        switch (target){
            case 1:
                if(gear[2].get(6) != gear[target].get(2)) {
                    if(dir[target] == 1)
                        dir[2] = -1;
                    else
                        dir[2] = 1;
                    move[2] = true;
                    if(gear[2].get(2) != gear[3].get(6)){
                        if(dir[2] == 1)
                            dir[3] = -1;
                        else
                            dir[3] = 1;
                        move[3] = true;
                        if(gear[3].get(2) != gear[4].get(6)) {
                            if (dir[3] == 1)
                                dir[4] = -1;
                            else
                                dir[4] = 1;
                            move[4] = true;
                        }
                    }
                }
                break;
            case 2:
                if(gear[target].get(6) != gear[1].get(2)){
                    if(dir[target] == 1)
                        dir[1] = -1;
                    else
                        dir[1] = 1;
                    move[1] = true;
                }
                if(gear[target].get(2) != gear[3].get(6)){
                    if(dir[target] == 1)
                        dir[3] = -1;
                    else
                        dir[3] = 1;
                    move[3] = true;
                    if(gear[3].get(2) != gear[4].get(6)){
                        if(dir[3] == 1)
                            dir[4] = -1;
                        else
                            dir[4] = 1;
                        move[4] = true;
                    }
                }
                break;
            case 3:
                if(gear[target].get(6) != gear[2].get(2)){
                    if(dir[target] == 1)
                        dir[2] = -1;
                    else
                        dir[2] = 1;
                    move[2] = true;
                    if(gear[2].get(6) != gear[1].get(2)) {
                        if (dir[2] == 1)
                            dir[1] = -1;
                        else
                            dir[1] = 1;
                        move[1] = true;
                    }
                }
                if(gear[target].get(2) != gear[4].get(6)) {
                    if (dir[target] == 1)
                        dir[4] = -1;
                    else
                        dir[4] = 1;
                    move[4] = true;
                }
                break;
            case 4:
                if(gear[target].get(6) != gear[3].get(2)){
                    if(dir[target] == 1)
                        dir[3] = -1;
                    else
                        dir[3] = 1;
                    move[3] = true;
                    if(gear[3].get(6) != gear[2].get(2)){
                        if(dir[3] == 1)
                            dir[2] = -1;
                        else
                            dir[2] = 1;
                        move[2] = true;
                        if(gear[2].get(6) != gear[1].get(2)){
                            if(dir[2] == 1)
                                dir[1] = -1;
                            else
                                dir[1] = 1;
                            move[1] = true;
                        }
                    }
                }
                break;
        }
    }
    public static void solve(){
        for(int i=0; i<k; i++){
            int target = opcode[i][0];
            dir[target] = opcode[i][1];
            currentCheck(target);
                for(int j=1; j<=4; j++){
                    if(move[j]){
                        if(dir[j] == 1) { //시계방향;
                            gear[j].addFirst(gear[j].getLast());
                            gear[j].removeLast();
                        }
                        else if(dir[j] == -1){ // 반시계방향;
                           gear[j].addLast(gear[j].getFirst());
                           gear[j].removeFirst();
                        }
                    }
                }
            for(int j=1; j<=4; j++){
                move[j] = false;
                dir[j] = 0;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        for(int i=1; i<=4; i++){
            gear[i] = new LinkedList<>();
            String str = br.readLine();
            for(int j=0; j<8; j++){
                gear[i].add(str.charAt(j)-'0');
            }
        }
        k = Integer.parseInt(br.readLine());
        opcode = new int[k][2];
        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            opcode[i][0] = Integer.parseInt(st.nextToken()); // 톱니바퀴 번호;
            opcode[i][1] = Integer.parseInt(st.nextToken()); // 회전시킬 방향; 1 시계 -1 반시계
        }

        solve();
        int ans = 0;
        if(gear[1].get(0) == 1)
            ans += 1;
        if(gear[2].get(0) == 1)
            ans += 2;
        if(gear[3].get(0) == 1)
            ans += 4;
        if(gear[4].get(0) == 1)
            ans += 8;
        bw.write(ans+"");
        bw.flush();
        bw.close();
    }
}