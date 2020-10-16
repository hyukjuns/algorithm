package samsungsw.review;

import java.io.*;
import java.util.StringTokenizer;

public class swea_14499 {
    static int n,m;
    static int y,x;
    static int numOfCommand;
    static int[] commands;
    static int[][] map;
    static int[][] dir = {{0,0},{0,1},{0,-1},{-1,0},{1,0}}; // 1 2 3 4 동 서 북 남
    public static boolean isValid(int dy, int dx){
        return (dy>=0 && dy < n) && (dx>=0 && dx <m) ? true:false;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        numOfCommand = Integer.parseInt(st.nextToken());
        commands = new int[numOfCommand];
        map = new int[n][m];
        for(int i=0; i<n; i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<numOfCommand; i++){
            commands[i] = Integer.parseInt(st.nextToken());
        }
        int[] cube = new int[7];
        for(int i=0;i<7; i++){
            cube[i]=0;
        }

        map[y][x] = cube[6];
        int ny,nx;
        int dy=y;
        int dx=x;
        int[] nextDice = new int[7];
        for(int i=0; i<numOfCommand; i++){
            int command = commands[i];
            ny = dy + dir[command][0];
            nx = dx + dir[command][1];
            if(!isValid(ny,nx)) continue;
            moveDice(command, cube, nextDice);
            if(map[ny][nx] == 0){
                map[ny][nx] = nextDice[6];
            }else{
                nextDice[6] = map[ny][nx];
                map[ny][nx] = 0;
            }
            bw.write(nextDice[1]+"\n");
            dy=ny;
            dx=nx;
            for(int k=0; k<7; k++)  cube[k] = nextDice[k];
        }
        bw.flush();
        bw.close();
    }
    public static void moveDice(int direct, int[] cube, int[] nextDice){
        if(direct==1){
            nextDice[1] = cube[4];
            nextDice[2] = cube[2];
            nextDice[3] = cube[1];
            nextDice[4] = cube[6];
            nextDice[5] = cube[5];
            nextDice[6] = cube[3];
        }else if(direct==2){
            nextDice[1] = cube[3];
            nextDice[2] = cube[2];
            nextDice[3] = cube[6];
            nextDice[4] = cube[1];
            nextDice[5] = cube[5];
            nextDice[6] = cube[4];
        }else if(direct==3){
            nextDice[1] = cube[5];
            nextDice[2] = cube[1];
            nextDice[3] = cube[3];
            nextDice[4] = cube[4];
            nextDice[5] = cube[6];
            nextDice[6] = cube[2];
        }else{
            nextDice[1] = cube[2];
            nextDice[2] = cube[6];
            nextDice[3] = cube[3];
            nextDice[4] = cube[4];
            nextDice[5] = cube[1];
            nextDice[6] = cube[5];
        }
    }
}
