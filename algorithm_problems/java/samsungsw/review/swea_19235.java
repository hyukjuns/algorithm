package samsungsw.review;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_19235 {
    // red 0~3
    // blue: col: 4~9, row: 0~3, light blue: col:0,1
    // green: col: 0~3, row:4~9 light green: row:0,1
    static int[][] map = new int[10][10];
    static int[][] dir = {{0,1},{1,0}}; //0: blue, 1: green
    static Queue<Block> blueQue = new LinkedList<>();
    static Queue<Block> greenQue = new LinkedList<>();
    public static boolean isValid(int dx, int dy){
        return (dx<10 && dx>=0) && (dy<10 && dy>=0) ? true:false;
    }
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int t, x, y;
        int block_id=1;
        int total=0;
        int c=0;
        int middleTotal=0;
        while(n-- > 0){
            st = new StringTokenizer(br.readLine());
            t = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            //System.out.println(c++);
            insert(block_id++,t,x,y,blueQue,greenQue);
//            System.out.println("삭제전");
//            for(int i=0; i<10; i++){
//                for(int j=0; j<10; j++){
//                    System.out.print(map[i][j]+" ");
//                }
//                System.out.println();
//            }
            while(true){
                middleTotal = delete();
                if(middleTotal==0)  break;
                total += middleTotal;
            }
//            System.out.println("삭제후");
//            for(int i=0; i<10; i++){
//                for(int j=0; j<10; j++){
//                    System.out.print(map[i][j]+" ");
//                }
//                System.out.println();
//            }
//            System.out.println();
        }
        int blockCount=0;
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                if(map[i][j]!=0)
                    blockCount++;
            }
        }
        bw.write(total+"\n");
        bw.write(blockCount+"");
        bw.flush();
        bw.close();
    }
    public static int delete(){
        // blue: col: 4~9, row: 0~3, light blue: col:4,5
        int cnt=0;
        for(int col=9; col>=6; col--){
            boolean isFull=false;
            for(int row=0; row<4; row++){
                if(map[row][col] != 0)  isFull=true;
                else{
                    isFull=false;
                    break;
                }
            }
            if(isFull){
                cnt++;
                for(int row=0; row<4; row++){
                    map[row][col]=0;
                }
            }
        }
        blueMove();
        //check light blue
        for(int i=0; i<2; i++){
            boolean isExist=false;
            for(int row=0; row<4; row++){
                if(map[row][5] != 0) {
                    isExist = true;
                    break;
                }
            }
            if(isExist){
                for(int row=0; row<4; row++){
                    map[row][9]=0;
                }
                blueMove();
            }
        }
        // green: col: 0~3, row:4~9 light green: row:4,5
        for(int row=9; row>=6; row--){
            boolean isFull=false;
            for(int col=0; col<4; col++){
                if(map[row][col] != 0)  isFull=true;
                else{
                    isFull=false;
                    break;
                }
            }
            if(isFull){
                cnt++;
                for(int col=0; col<4; col++){
                    map[row][col]=0;
                }
            }
        }
        greenMove();
        //check light green
        for(int i=0; i<2; i++){
            boolean isExist=false;
            for(int col=0; col<4; col++) {
                if (map[5][col] != 0){
                    isExist = true;
                    break;
                }
            }
            if(isExist){
                for(int col=0; col<4; col++){
                    map[9][col]=0;
                }
                greenMove();
            }
        }
        return cnt;
    }
    public static void moveTypeOne(String color, int block_id, int t, int x, int y, Queue<Block> q){
        map[x][y]=0;
        if(color.equals("Blue")) {
            int dx = x;
            int dy = y;
            int nx, ny;
            while (true) {
                nx = dx + dir[0][0];
                ny = dy + dir[0][1];
                if (!isValid(nx, ny) || map[nx][ny] != 0) break;
                dx = nx;
                dy = ny;
            }
            map[dx][dy] = block_id;
            q.add(new Block(t, dx, dy, block_id));
        }else {
            //green
            int dx = x;
            int dy = y;
            int nx, ny;
            while (true) {
                nx = dx + dir[1][0];
                ny = dy + dir[1][1];
                if (!isValid(nx, ny) || map[nx][ny] != 0) break;
                dx = nx;
                dy = ny;
            }
            map[dx][dy] = block_id;
            q.add(new Block(t, dx, dy, block_id));
        }
    }
    public static void moveTypeTwo(String color, int block_id, int t, int x, int y, Queue<Block> q){
        if(color.equals("Blue")) {
            //blue
            int dx = x;
            int dy = y;
            int nx, ny;
            while (true) {
                nx = dx + dir[0][0];
                ny = dy + dir[0][1];
                if (!isValid(nx, ny) || map[nx][ny] != 0) break;
                dx = nx;
                dy = ny;
            }
            map[x][y-1]=map[x][y]=0;
            map[dx][dy - 1] = map[dx][dy] = block_id;
            q.add(new Block(t, dx, dy, block_id));
        }else {
            //green
            int dx = x;
            int dy = y;
            int ny, nx;
            while (true) {
                nx = dx + dir[1][0];
                ny = dy + dir[1][1];
                if (!isValid(nx, ny) || map[nx][ny] != 0 || map[nx][ny + 1] != 0) break;
                dx = nx;
                dy = ny;
            }
            map[x][y]=map[x][y+1]=0;
            map[dx][dy] = map[dx][dy + 1] = block_id;
            q.add(new Block(t, dx, dy, block_id));
        }
    }
    public static void moveTypeThree(String color, int block_id, int t, int x, int y, Queue<Block> q){
        if(color.equals("Blue")) {
            //blue
            int dx = x;
            int dy = y;
            int nx, ny;
            while (true) {
                nx = dx + dir[0][0];
                ny = dy + dir[0][1];
                if (!isValid(nx, ny) || map[nx][ny] != 0 || map[nx + 1][ny] != 0) break;
                dx = nx;
                dy = ny;
            }
            map[x][y]=map[x+1][y]=0;
            map[dx][dy] = map[dx + 1][dy] = block_id;
            q.add(new Block(t, dx, dy, block_id));
        }else {
            //green
            int dx = x;
            int dy = y;
            int ny, nx;
            while (true) {
                nx = dx + dir[1][0];
                ny = dy + dir[1][1];
                if (!isValid(nx, ny) || map[nx][ny] != 0) break;
                dx = nx;
                dy = ny;
            }
            map[x-1][y]=map[x][y]=0;
            map[dx - 1][dy] = map[dx][dy] = block_id;
            q.add(new Block(t, dx, dy, block_id));
        }
    }
    public static void blueMove(){
        //blue
        Queue<Block> nBlueQue = new LinkedList<>();
        while(!blueQue.isEmpty()){
            Block temp = blueQue.poll();
            if(temp.type==1){
                if(map[temp.dx][temp.dy]==0){
                    continue;
                }else{
                    moveTypeOne("Blue",temp.b_id, temp.type, temp.dx, temp.dy, nBlueQue);
                }
            }else if(temp.type==2){
                if(map[temp.dx][temp.dy]==0 && map[temp.dx][temp.dy-1]==0)    continue;
                else if(map[temp.dx][temp.dy]==0){
                    if(map[temp.dx][temp.dy-1]!=0)
                        moveTypeOne("Blue",temp.b_id, 1, temp.dx, temp.dy-1, nBlueQue);
                }else if(map[temp.dx][temp.dy-1]==0){
                    if(map[temp.dx][temp.dy] != 0)
                        moveTypeOne("Blue",temp.b_id, 1, temp.dx, temp.dy, nBlueQue);
                } else{
                   moveTypeTwo("Blue",temp.b_id, temp.type, temp.dx, temp.dy, nBlueQue);
                }
            }else{
                if(map[temp.dx][temp.dy]==0){
                    continue;
                }else{
                    moveTypeThree("Blue",temp.b_id, temp.type, temp.dx, temp.dy, nBlueQue);
                }
            }
        }
        while(!nBlueQue.isEmpty()){
            blueQue.add(nBlueQue.poll());
        }
    }
    public static void greenMove(){
        //blue
        Queue<Block> nGreenQue = new LinkedList<>();
        while(!greenQue.isEmpty()){
            Block temp = greenQue.poll();
            if(temp.type==1){
                if(map[temp.dx][temp.dy]==0){
                    continue;
                }else{
                    moveTypeOne("Green",temp.b_id, temp.type, temp.dx, temp.dy, nGreenQue);
                }
            }else if(temp.type==2){
                if(map[temp.dx][temp.dy]==0){
                    continue;
                }else{
                    moveTypeTwo("Green",temp.b_id, temp.type, temp.dx, temp.dy, nGreenQue);
                }
            }else{
                if(map[temp.dx][temp.dy]==0 && map[temp.dx-1][temp.dy] ==0)    continue;
                else if(map[temp.dx][temp.dy]==0){
                    if(map[temp.dx-1][temp.dy]!=0)
                        moveTypeOne("Green",temp.b_id, 1, temp.dx-1, temp.dy, nGreenQue);
                }else if(map[temp.dx-1][temp.dy] == 0){
                    if(map[temp.dx][temp.dy] != 0)
                        moveTypeOne("Green",temp.b_id, 1, temp.dx, temp.dy, nGreenQue);
                } else{
                    moveTypeThree("Green",temp.b_id, temp.type, temp.dx, temp.dy, nGreenQue);
                }
            }
        }
        while(!nGreenQue.isEmpty()){
            greenQue.add(nGreenQue.poll());
        }
    }
    public static void insert(int block_id,int t, int x, int y,Queue<Block> bq, Queue<Block> gq){
        if(t==1){
            //blue
            int dx=x;
            int dy=y;
            int nx,ny;
            while(true){
                nx = dx + dir[0][0];
                ny = dy + dir[0][1];
                if(!isValid(nx,ny) || map[nx][ny] != 0) break;
                dx = nx;
                dy = ny;
            }
            map[dx][dy]=block_id;
            bq.add(new Block(t,dx,dy,block_id));
            //green
            dx=x;
            dy=y;
            while(true){
                nx = dx + dir[1][0];
                ny = dy + dir[1][1];
                if(!isValid(nx,ny) || map[nx][ny] != 0) break;
                dx = nx;
                dy = ny;
            }
            map[dx][dy]=block_id;
            gq.add(new Block(t,dx,dy,block_id));
        }else if(t==2){
            //blue
            int dx = x;
            int dy = y+1;
            int nx,ny;
            while(true){
                nx = dx+dir[0][0];
                ny = dy+dir[0][1];
                if(!isValid(nx,ny) || map[nx][ny] != 0) break;
                dx=nx;
                dy=ny;
            }
            map[dx][dy-1] = map[dx][dy] = block_id;
            bq.add(new Block(t,dx,dy,block_id));
            //green
            dx=x;
            dy=y;
            while(true){
                nx=dx+dir[1][0];
                ny=dy+dir[1][1];
                if(!isValid(nx,ny) || map[nx][ny] != 0 || map[nx][ny+1] != 0) break;
                dx=nx;
                dy=ny;
            }
            map[dx][dy] = map[dx][dy+1] = block_id;
            gq.add(new Block(t,dx,dy,block_id));
        }else{
            //blue
            int dx = x;
            int dy = y;
            int nx,ny;
            while(true){
                nx = dx + dir[0][0];
                ny = dy + dir[0][1];
                if(!isValid(nx,ny) || map[nx][ny] !=0 || map[nx+1][ny] != 0)    break;
                dx = nx;
                dy = ny;
            }
            map[dx][dy]=map[dx+1][dy] = block_id;
            bq.add(new Block(t,dx,dy,block_id));
            //green
            dx=x+1;
            dy=y;
            while(true){
                nx=dx+dir[1][0];
                ny=dy+dir[1][1];
                if(!isValid(nx,ny) || map[nx][ny]!=0)  break;
                dx=nx;
                dy=ny;
            }
            map[dx-1][dy]=map[dx][dy]=block_id;
            gq.add(new Block(t,dx,dy,block_id));
        }

    }
}
class Block{
    int type;
    int dx;
    int dy;
    int b_id;
    public Block(int type, int dx, int dy, int b_id){
        this.type=type;
        this.dx=dx;
        this.dy=dy;
        this.b_id=b_id;
    }
}