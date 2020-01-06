package boj.Simulation;

import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Simulation_3190 {
    private static int n,k,l;
    private static int[][] map;
    private static int timeCnt=0;
    private static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}}; //동 남 서 북 0 1 2 3 (x,y) (열,행)
    public static int solve(Queue<Order> order){
        int headY=1,headX=1;
        int nheadY,nheadX;
        int d = 0;
        Queue<Point> tail = new LinkedList<>();
        tail.add(new Point(1,1));
        map[headY][headX] = 2; //시작위치
        while(true){ //0 빈칸, 1 사과, 2 뱀의 몸
            timeCnt++;
            //뱀 이동
            nheadX = headX + dir[d][0];
            nheadY = headY + dir[d][1];
            //종료조건 체크
            if(nheadX > n || nheadX < 1 || nheadY > n || nheadY < 1)
                return timeCnt;
            else if(map[nheadY][nheadX] == 2)
                return timeCnt;

            //사과 여부 체크
            if(map[nheadY][nheadX] == 1){ //사과 존재, 몸길이 늘어남, 꼬리 그대로
                map[nheadY][nheadX] = 2;
                headX = nheadX;
                headY = nheadY;
                tail.add(new Point(headX,headY)); //꼬리추가
            }
            else{//사과없음, 꼬리 줄이기
                map[nheadY][nheadX] = 2;
                headX = nheadX;
                headY = nheadY;
                tail.add(new Point(headX,headY));
                map[tail.peek().y][tail.peek().x] = 0;//꼬리 지우기
                tail.poll();//꼬리 지우기
            }
            //방향 전환
            if(!order.isEmpty() && timeCnt == order.peek().time){
                if(order.peek().direct == 'L')
                    d = (d+3) % 4;
                else if(order.peek().direct == 'D') {
                    d += 1;
                    d %= 4;
                }
                order.poll();
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        map = new int[n+1][n+1];
        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            map[y][x] = 1;
        }
        l = Integer.parseInt(br.readLine());
        Queue<Order> order = new LinkedList<>();
        for(int i=0; i<l; i++){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            char d = st.nextToken().charAt(0);
            order.add(new Order(t,d));
        }

        int result = solve(order);
        bw.write(result+"");
        bw.flush();
        bw.close();
    }
}
class Order{
    int time;
    char direct;
    public Order(int time, char direct){
        this.time = time;
        this.direct = direct;
    }
}