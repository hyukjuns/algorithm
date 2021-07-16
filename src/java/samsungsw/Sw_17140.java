package samsungsw;

import java.io.*;
import java.util.*;

public class Sw_17140 {
    static int r,c,k;
    static ArrayList<Integer>[][] map;
    static ArrayList<Integer>[][] nextMap;

    static void sortRow(){
        ArrayList<Pair>[] pairs = new ArrayList[map.length];
        boolean[] visited;
        for(int i=0; i<map.length; i++){
            pairs[i] = new ArrayList<>();
            visited = new boolean[101];
            for(int j=0; j<map[i].length; j++){
                int cnt=0;
                if(!visited[map[i][j].get(0)] && map[i][j].get(0) != 0){
                    visited[map[i][j].get(0)] = true;
                    for(int k=j; k<map[i].length; k++){
                        if(map[i][j].get(0)==map[i][k].get(0)){
                            cnt++;
                        }
                    }
                    pairs[i].add(new Pair(map[i][j].get(0),cnt));
                }
            }
            Collections.sort(pairs[i], new Comparator<Pair>() {
                @Override
                public int compare(Pair o1, Pair o2) {
                    if(o1.cnt > o2.cnt){
                        return 1;
                    }
                    else if(o1.cnt == o2.cnt){
                        if(o1.num > o2.num){
                            return 1;
                        }
                    }
                    return -1;
                }
            });
        }
        int maxLen=0;
        for(int i=0; i<pairs.length; i++){
            if(maxLen < pairs[i].size()){
                maxLen = pairs[i].size();
            }
        }
        for(int i=0; i<pairs.length; i++){
            if(pairs[i].size()<maxLen){
                while(pairs[i].size() != maxLen){
                    pairs[i].add(new Pair(0,0));
                }
            }
        }
        nextMap = new ArrayList[map.length][maxLen*2];
        for(int i=0; i<map.length; i++){
            int idx=0;
            for(int j=0; j<maxLen; j++){
                int num = pairs[i].get(j).num;
                int cnt = pairs[i].get(j).cnt;
                nextMap[i][idx] = new ArrayList<>();
                nextMap[i][idx+1] = new ArrayList<>();
                nextMap[i][idx].add(num);
                nextMap[i][idx+1].add(cnt);
                idx+=2;
            }
        }
        //print();
    }
    static void sortCol(){
        ArrayList<Pair>[] pairs = new ArrayList[map[0].length];
        boolean[] visited;
        for(int i=0; i<map[0].length; i++){
            pairs[i] = new ArrayList<>();
            visited = new boolean[101];
            for(int j=0; j<map.length; j++){
                int cnt=0;
                if(!visited[map[j][i].get(0)] && map[j][i].get(0) != 0){
                    visited[map[j][i].get(0)] = true;
                    for(int k=j; k<map.length; k++){
                        if(map[j][i].get(0)==map[k][i].get(0)){
                            cnt++;
                        }
                    }
                    pairs[i].add(new Pair(map[j][i].get(0),cnt));
                }
            }
            Collections.sort(pairs[i], new Comparator<Pair>() {
                @Override
                public int compare(Pair o1, Pair o2) {
                    if(o1.cnt > o2.cnt){
                        return 1;
                    }
                    else if(o1.cnt == o2.cnt){
                        if(o1.num > o2.num){
                            return 1;
                        }
                    }
                    return -1;
                }
            });
        }

        int maxLen=0;
        for(int i=0; i<pairs.length; i++){
            if(maxLen < pairs[i].size()){
                maxLen = pairs[i].size();
            }
        }
        for(int i=0; i<pairs.length; i++){
            if(pairs[i].size()<maxLen){
                while(pairs[i].size() != maxLen){
                    pairs[i].add(new Pair(0,0));
                }
            }
        }
        nextMap = new ArrayList[maxLen*2][map[0].length];
        for(int i=0; i<map[0].length; i++){
            int idx=0;
            for(int j=0; j<maxLen; j++){
                int num = pairs[i].get(j).num;
                int cnt = pairs[i].get(j).cnt;
                nextMap[idx][i] = new ArrayList<>();
                nextMap[idx+1][i] = new ArrayList<>();
                nextMap[idx][i].add(num);
                nextMap[idx+1][i].add(cnt);
                idx+=2;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken())-1;
        c = Integer.parseInt(st.nextToken())-1;
        k = Integer.parseInt(st.nextToken());

        map = new ArrayList[3][3];
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                map[i][j] = new ArrayList<>();
            }
        }
        for(int i=0; i<3; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                map[i][j].add(Integer.parseInt(st.nextToken()));
            }
        }

        int count=0;
        while(count<=100){
            if(r < map.length && c < map[0].length && map[r][c].get(0)==k){
                break;
            }
            //R 연산: 배열 A의 모든 행에 대해서 정렬을 수행한다. 행의 개수 ≥ 열의 개수인 경우에 적용된다.
            if(map.length >= map[0].length){// R 연산
                sortRow();
            }
            //C 연산: 배열 A의 모든 열에 대해서 정렬을 수행한다. 행의 개수 < 열의 개수인 경우에 적용된다.
            else if(map.length < map[0].length){// C 연산
                sortCol();
            }
            map = new ArrayList[nextMap.length][nextMap[0].length];
            copyArr();
            count++;
//            print();
//            System.out.println();
        }
        //100을 넘어가는 경우에는 -1을 출력한다.
        if(count>100)
            count=-1;
        bw.write(count+"");
        bw.flush();
        bw.close();
    }
    static void copyArr(){
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[0].length; j++){
                map[i][j] = new ArrayList<>();
                map[i][j].add(nextMap[i][j].get(0));
            }
        }
    }
    static void print(){
        for(int i=0; i<nextMap.length; i++){
            for(int j=0; j<nextMap[i].length; j++){
                System.out.print(nextMap[i][j].get(0)+" ");
            }
            System.out.println();
        }
    }
}
class Pair{
    int num;
    int cnt;
    public Pair(int num, int cnt){
        this.num = num;
        this.cnt = cnt;
    }
}
