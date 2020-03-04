package samsungsw;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Sw_17281 {
    static int n;
    static int[][] inning;
    static boolean[] players = new boolean[10];
    static int sum=Integer.MIN_VALUE;

    public static void startGame(String order){
        Deque<Integer> gameLineUp = new LinkedList<>();
        for(int i=0; i<order.length(); i++){
            gameLineUp.add(order.charAt(i)-'0');
        }

        int score=0;
        int hit;
        for(int i=1; i<=n; i++){
            int out=0;
            int[] ground = new int[4];
            while(out<3){
                int player = gameLineUp.pollFirst();
                hit = inning[i][player];
                if(hit==0){
                    out++;
                }
                else if(hit==1){
                    for(int k=3; k>=1; k--){
                        if(ground[k]==1){
                            if(k==3){
                                score++;
                                ground[k]=0;
                            }
                            else{
                                ground[k+1] = 1;
                                ground[k]=0;
                            }
                        }
                    }
                    ground[1] = 1;
                }
                else if(hit==2){
                    for(int k=3; k>=1; k--){
                        if(ground[k]==1){
                            if(k==3 || k==2){
                                score++;
                                ground[k] = 0;
                            }
                            else{
                                ground[k+2] = 1;
                                ground[k] = 0;
                            }
                        }
                    }
                    ground[2] = 1;
                }
                else if(hit==3){
                    for(int k=3; k>=1; k--){
                        if(ground[k]==1){
                            score++;
                            ground[k]=0;
                        }
                    }
                    ground[3]=1;
                }
                else{
                    for(int k=1; k<=3; k++){
                        if(ground[k] ==1){
                            score++;
                            ground[k]=0;
                        }
                    }
                    score++;
                }
                gameLineUp.addLast(player);
            }
        }
        sum = Math.max(sum,score);
    }

    public static void makeOrder(String order){
        if(order.length()==8){
            StringBuilder sb = new StringBuilder(order);
            sb.insert(3,1);
            order = sb.toString();
            //System.out.println(order);
            startGame(order);
            return;
        }
        for(int i=1; i<=9; i++){
            if(!players[i]){
                players[i] = true;
                makeOrder(order+i);
                players[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        inning = new int[n+1][10];

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=9; j++){
                inning[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        players[1] = true;
        makeOrder("");
        bw.write(sum+"");
        bw.flush();
        bw.close();
    }
}
