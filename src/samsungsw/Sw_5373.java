package samsungsw;

import java.io.*;
import java.util.StringTokenizer;

public class Sw_5373 {
    static char[][][] cube;
    static char[][][] temp;
    public static void copyArr(){
        for(int i=0; i<6; i++){
            for(int j=0; j<3; j++){
                for(int k=0; k<3; k++){
                    cube[i][j][k] = temp[i][j][k];
                }
            }
        }
    }
    public static void solve(String[] opcode){
        // +인 경우에는 시계 방향 (그 면을 바라봤을 때가 기준), -인 경우에는 반시계 방향
        for(String str : opcode){
            char face = str.charAt(0);
            char dir = str.charAt(1);
            switch (face) {
                case 'U': {
                    if (dir == '+') {
                        for(int i=0; i<3; i++){
                            for(int j=0; j<3; j++){
                                temp[0][j][2-i] = cube[0][i][j];
                            }
                        }
                        for(int i=2; i<=5; i++){
                            for(int k=0; k<3; k++){
                                if(i==2)
                                    temp[2][0][k] = cube[5][0][k];
                                else if(i==3)
                                    temp[3][0][k] = cube[4][0][k];
                                else if(i==4)
                                    temp[4][0][k] = cube[2][0][k];
                                else if(i==5)
                                    temp[5][0][k] = cube[3][0][k];
                            }
                        }
                        copyArr();

                    } else {
                        for(int i=0; i<3; i++){
                            for(int j=0; j<3; j++){
                                temp[0][i][j] = cube[0][j][2-i];
                            }
                        }
                        for(int i=2; i<=5; i++){
                            for(int k=0; k<3; k++){
                                if(i==2)
                                    temp[2][0][k] = cube[4][0][k];
                                else if(i==3)
                                    temp[3][0][k] = cube[5][0][k];
                                else if(i==4)
                                    temp[4][0][k] = cube[3][0][k];
                                else if(i==5)
                                    temp[5][0][k] = cube[2][0][k];
                            }
                        }
                        copyArr();
                    }
                }
                break;
                case 'D': {
                    if (dir == '+') {
                        for(int i=0; i<3; i++){
                            for(int j=0; j<3; j++){
                                temp[1][j][2-i] = cube[1][i][j];
                            }
                        }
                        for(int i=2; i<=5; i++){
                            for(int k=0; k<3; k++){
                                if(i==2)
                                    temp[2][2][k] = cube[4][2][k];
                                else if(i==3)
                                    temp[3][2][k] = cube[5][2][k];
                                else if(i==4)
                                    temp[4][2][k] = cube[3][2][k];
                                else if(i==5)
                                    temp[5][2][k] = cube[2][2][k];
                            }
                        }
                        copyArr();
                    } else {
                        for(int i=0; i<3; i++){
                            for(int j=0; j<3; j++){
                                temp[1][i][j]= cube[1][j][2-i];
                            }
                        }
                        for(int i=2; i<=5; i++){
                            for(int k=0; k<3; k++){
                                if(i==2)
                                    temp[2][2][k] = cube[5][2][k];
                                else if(i==3)
                                    temp[3][2][k] = cube[4][2][k];
                                else if(i==4)
                                    temp[4][2][k] = cube[2][2][k];
                                else if(i==5)
                                    temp[5][2][k] = cube[3][2][k];
                            }
                        }
                        copyArr();
                    }
                }
                break;
                case 'F':{
                    if (dir == '+') {
                        for(int i=0; i<3; i++){
                            for(int j=0; j<3; j++){
                                temp[2][j][2-i]= cube[2][i][j];
                            }
                        }
                        //D
                        for(int k=0; k<3; k++){
                            temp[1][2][k] = cube[5][k][0];
                        }
                        //L
                        for(int k=0; k<3; k++){
                            temp[4][2-k][2] = cube[1][2][k];
                        }
                        //U
                        for(int k=0; k<3; k++){
                            temp[0][2][2-k] = cube[4][k][2];
                        }
                        //R
                        for(int k=0; k<3; k++){
                            temp[5][k][0] = cube[0][2][k];
                        }
                        copyArr();
                    } else {
                        for(int i=0; i<3; i++){
                            for(int j=0; j<3; j++){
                                temp[2][i][j]= cube[2][j][2-i];
                            }
                        }
                        //D
                        for(int k=0; k<3; k++){
                            temp[1][2][2-k] = cube[4][k][2];
                        }
                        //L
                        for(int k=0; k<3; k++){
                            temp[4][2-k][2] = cube[0][2][k];
                        }
                        //U
                        for(int k=0; k<3; k++){
                            temp[0][2][k] = cube[5][k][0];
                        }
                        //R
                        for(int k=0; k<3; k++){
                            temp[5][k][0] = cube[1][2][k];
                        }
                        copyArr();
                    }
                }
                break;
                case 'B': {
                    if (dir == '+') {
                        for(int i=0; i<3; i++){
                            for(int j=0; j<3; j++){
                                temp[3][j][2-i]= cube[3][i][j];
                            }
                        }
                        //D
                        for(int k=0; k<3; k++){
                            temp[1][0][2-k] = cube[4][k][0];
                        }
                        //L
                        for(int k=0; k<3; k++){
                            temp[4][2-k][0] = cube[0][0][k];
                        }
                        //U
                        for(int k=0; k<3; k++){
                            temp[0][0][k] = cube[5][k][2];
                        }
                        //R
                        for(int k=0; k<3; k++){
                            temp[5][k][2] = cube[1][0][k];
                        }
                        copyArr();
                    } else {
                        for(int i=0; i<3; i++){
                            for(int j=0; j<3; j++){
                                temp[3][i][j]= cube[3][j][2-i];
                            }
                        }
                        //D
                        for(int k=0; k<3; k++){
                            temp[1][0][k] = cube[5][k][2];
                        }
                        //L
                        for(int k=0; k<3; k++){
                            temp[4][2-k][0] = cube[1][0][k];
                        }
                        //U
                        for(int k=0; k<3; k++){
                            temp[0][0][2-k] = cube[4][k][0];
                        }
                        //R
                        for(int k=0; k<3; k++){
                            temp[5][k][2] = cube[0][0][k];
                        }
                        copyArr();
                    }
                }
                break;
                case 'L':{
                    if(dir=='+'){
                        for(int i=0; i<3; i++){
                            for(int j=0; j<3; j++){
                                temp[4][j][2-i]= cube[4][i][j];
                            }
                        }
                        for(int i=0; i<=3; i++){
                            if(i==0){
                                for(int k=0; k<3; k++){
                                    temp[0][2-k][0] = cube[3][k][2];
                                }
                            }
                            else if(i==1){
                                for(int k=0; k<3; k++){
                                    temp[1][2-k][2] = cube[2][k][0];
                                }
                            }
                            else if(i==2){
                                for(int k=0; k<3; k++){
                                    temp[2][k][0] = cube[0][k][0];
                                }
                            }
                            else if(i==3){
                                for(int k=0; k<3; k++){
                                    temp[3][k][2] = cube[1][k][2];
                                }
                            }
                        }
                        copyArr();
                    }
                    else{
                        for(int i=0; i<3; i++){
                            for(int j=0; j<3; j++){
                                temp[4][i][j]= cube[4][j][2-i];
                            }
                        }
                        for(int i=0; i<=3; i++){
                            if(i==0){
                                for(int k=0; k<3; k++){
                                    temp[0][k][0] = cube[2][k][0];
                                }
                            }
                            else if(i==1){
                                for(int k=0; k<3; k++){
                                    temp[1][k][2] = cube[3][k][2];
                                }
                            }
                            else if(i==2){
                                for(int k=0; k<3; k++){
                                    temp[2][2-k][0] = cube[1][k][2];
                                }
                            }
                            else if(i==3){
                                for(int k=0; k<3; k++){
                                    temp[3][2-k][2] = cube[0][k][0];
                                }
                            }
                        }
                        copyArr();
                    }
                }
                break;
                case 'R':{
                    if(dir=='+'){
                        for(int i=0; i<3; i++){
                            for(int j=0; j<3; j++){
                                temp[5][j][2-i]= cube[5][i][j];
                            }
                        }
                        for(int i=0; i<=3; i++){
                            if(i==0){
                                for(int k=0; k<3; k++){
                                    temp[0][k][2] = cube[2][k][2];
                                }
                            }
                            else if(i==1){
                                for(int k=0; k<3; k++){
                                    temp[1][k][0] = cube[3][k][0];
                                }
                            }
                            else if(i==2){
                                for(int k=0; k<3; k++){
                                    temp[2][2-k][2] = cube[1][k][0];
                                }
                            }
                            else if(i==3){
                                for(int k=0; k<3; k++){
                                    temp[3][2-k][0] = cube[0][k][2];
                                }
                            }
                        }
                        copyArr();
                    }
                    else{
                        for(int i=0; i<3; i++){
                            for(int j=0; j<3; j++){
                                temp[5][i][j]= cube[5][j][2-i];
                            }
                        }
                        for(int i=0; i<=3; i++){
                            if(i==0){
                                for(int k=0; k<3; k++){
                                    temp[0][2-k][2] = cube[3][k][0];
                                }
                            }
                            else if(i==1){
                                for(int k=0; k<3; k++){
                                    temp[1][2-k][0] = cube[2][k][2];
                                }
                            }
                            else if(i==2){
                                for(int k=0; k<3; k++){
                                    temp[2][k][2] = cube[0][k][2];
                                }
                            }
                            else if(i==3){
                                for(int k=0; k<3; k++){
                                    temp[3][k][0] = cube[1][k][0];
                                }
                            }
                        }
                        copyArr();
                    }
                }
                break;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        int tc= Integer.parseInt(br.readLine());
        while(tc-- > 0){
            cube = new char[6][3][3];
            temp = new char[6][3][3];
            //흰색은 w, 노란색은 y, 빨간색은 r, 오렌지색은 o, 초록색은 g, 파란색은 b.
            //U: 윗 면, D: 아랫 면, F: 앞 면, B: 뒷 면, L: 왼쪽 면, R: 오른쪽 면이다.
            for(int i=0; i<6; i++){
                for(int j=0; j<3; j++){
                    for(int k=0; k<3; k++){
                        if(i==0)
                            temp[i][j][k] = cube[i][j][k] = 'w';
                        else if(i==1)
                            temp[i][j][k] = cube[i][j][k] = 'y';
                        else if(i==2)
                            temp[i][j][k] = cube[i][j][k] = 'r';
                        else if(i==3)
                            temp[i][j][k] = cube[i][j][k] = 'o';
                        else if(i==4)
                            temp[i][j][k] = cube[i][j][k] = 'g';
                        else if(i==5)
                            temp[i][j][k] = cube[i][j][k] = 'b';
                    }
                }
            }
            //첫째 줄에 큐브를 돌린 횟수 n이 주어진다. (1 ≤ n ≤ 1000)
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            String[] opcode = new String[n];
            for(int i=0; i<n; i++){
                opcode[i] = st.nextToken();
            }
            solve(opcode);
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    System.out.print(cube[0][i][j]);
                }
                System.out.println();
            }
        }

    }
}
