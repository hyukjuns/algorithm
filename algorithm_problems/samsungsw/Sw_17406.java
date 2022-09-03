package samsungsw;

import java.io.*;
import java.util.StringTokenizer;

public class Sw_17406 {
    static int n,m,k;
    static int[][] map;
    static int[][] opcode;
    static boolean[] used;
    static int ans=Integer.MAX_VALUE;

    static void print(int[][] map){
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[i].length; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
    static int startCal(String order, int[][] originMap){
        int[][] copyMap = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                copyMap[i][j] = originMap[i][j];
            }
        }
        for(int i=0; i<order.length(); i++){
            int r = opcode[order.charAt(i)-'0'][0];
            int c = opcode[order.charAt(i)-'0'][1];
            int s = opcode[order.charAt(i)-'0'][2];
            int rowSize = 2*s+1;
            int colSize = 2*s+1;
            int[][] tempMap = new int[rowSize][colSize];
            int ridx=0;
            for(int k=r-s; k<=r+s; k++,ridx++){
                int cidx=0;
                for(int m=c-s; m<=c+s; m++,cidx++){
                    tempMap[ridx][cidx] = copyMap[k][m];
                }
            }
            for(int j=0; j<s; j++){
                int temp = tempMap[j][j];
                for(int k=j+1; k<rowSize-j; k++){
                    tempMap[k-1][j] = tempMap[k][j];
                }
                for(int k=1+j; k<colSize-j; k++){
                    tempMap[rowSize-1-j][k-1] = tempMap[rowSize-1-j][k];
                }
                for(int k=rowSize-2-j; k>=j; k--){
                    tempMap[k+1][colSize-1-j] = tempMap[k][colSize-1-j];
                }
                for(int k=colSize-2-j; k>j; k--){
                    tempMap[j][k+1] = tempMap[j][k];
                }
                tempMap[j][1+j] = temp;
            }
            ridx=0;
            for(int k=r-s; k<=r+s; k++,ridx++){
                int cidx=0;
                for(int m=c-s; m<=c+s; m++,cidx++){
                     copyMap[k][m] = tempMap[ridx][cidx];
                }
            }
           // print(tempMap);
        }
        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            int sum=0;
            for(int j=0; j<m; j++){
                sum += copyMap[i][j];
            }
            min = Math.min(min,sum);
        }
        return min;
    }
    static void makeOrder(String order){
        if(order.length() == k){
            ans = Math.min(ans,startCal(order,map));
            //System.out.println(order);
            return;
        }
        for(int i=0; i<k; i++){
            if(!used[i]){
                used[i] = true;
                makeOrder(order+i);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        opcode = new int[k][3];
        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                if(j==2)
                    opcode[i][j] = Integer.parseInt(st.nextToken());
                else
                    opcode[i][j] = Integer.parseInt(st.nextToken())-1;
            }
           // System.out.println(opcode[i][0]+""+opcode[i][1]+""+opcode[i][2]);
        }
        used = new boolean[k];
        makeOrder("");
        bw.write(ans+"");
        bw.flush();
        bw.close();
    }
}
