package samsungsw.review;

import java.awt.*;
import java.io.*;
import java.lang.management.ThreadInfo;
import java.net.Inet4Address;
import java.util.*;

public class swea_19236 {
    static int total=0;
    static int[][] dir = {{-1,0},{-1,-1},{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1}};
    static int[][] map = new int[4][4];
    static int ans=Integer.MIN_VALUE;
    static HashMap<Integer,FishInfo> flist = new HashMap<>();

    static FishInfo jaws = new FishInfo(0,0,0,0);
    public static boolean isValid(int dy, int dx){
        return (dy>=0 && dy<4) && (dx>=0 && dx<4) ? true:false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int val = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken()) - 1; //Array dir's index range is 0~7
                map[i][j] = val;
                flist.put(val,new FishInfo(val,d,i,j));
            }
        }
//        Collections.sort(flist, new Comparator<FishInfo>(){
//            @Override
//            public int compare(FishInfo o1, FishInfo o2){
//                if(o1.val > o2.val){
//                    return 1;
//                }else{
//                    return -1;
//                }
//            }
//        });
        jaws.direct=flist.get(map[0][0]).direct;
        jaws.val=flist.get(map[0][0]).val;
        jaws.dy=flist.get(map[0][0]).dy;
        jaws.dx=flist.get(map[0][0]).dx;
        flist.remove(map[0][0]);
        //System.out.println(jaws.val+"jaswval");
        ans = map[0][0];
        map[0][0] = -1;
        solution(map,flist,jaws);
        bw.write(ans+"");
        bw.flush();
        bw.close();

    }
    public static void solution(int[][] tempMap, HashMap<Integer, FishInfo> flist, FishInfo jaws){
        //move fish
        int ny,nx;
        for(int i=1; i<=16; i++){
            if(flist.get(i) == null)    continue;
            int dy=flist.get(i).dy;
            int dx = flist.get(i).dx;
            int direct = flist.get(i).direct;
            int k;
            for(k=0; k<8; k++){
                ny = dy + dir[(direct+k)%8][0];
                nx = dx + dir[(direct+k)%8][1];
                if(isValid(ny,nx) && tempMap[ny][nx] != -1){
                    if(tempMap[ny][nx] == 0){
                        tempMap[flist.get(i).dy][flist.get(i).dx] = 0;
                        tempMap[ny][nx] = flist.get(i).val;
                        flist.get(i).dy = ny;
                        flist.get(i).dx = nx;
                        flist.get(i).direct=direct;
                    }else{
                        // change map's value
                        int temp = tempMap[ny][nx];
                        tempMap[ny][nx] = flist.get(i).val;
                        tempMap[flist.get(i).dy][flist.get(i).dx] = temp;
                        // change fish's info
                        print(tempMap);
                        System.out.println(i+"<< it is i val");
                        System.out.println(flist.get(i).val+"<< it is i's val");
                        System.out.println(temp+" << it is temp val");
                        System.out.println(flist.get(temp).val+"<< it is temp's val");
                        flist.get(temp).dy = flist.get(i).dy;
                        flist.get(temp).dx = flist.get(i).dx;
                        flist.get(i).dy=ny;
                        flist.get(i).dx=nx;
                        flist.get(i).direct=direct;
                    }
                }
            }
            if(k==8){
                flist.get(i).direct=direct;
            }
        }
        //move jaws
        int[][] nextMap = new int[4][4];
        HashMap<Integer, FishInfo> nextHash = new HashMap<>();
        int dy = jaws.dy;
        int dx = jaws.dx;
        int direct = jaws.direct;
        FishInfo tempFish;
        FishInfo nextJaws = new FishInfo(0,0,0,0);
        while(true){
            ny = dy + dir[direct%8][0];
            nx = dx + dir[direct%8][1];
            if(!isValid(ny,nx)) break;
            if(isValid(ny,nx) && tempMap[ny][nx]==0){
                dy = ny;
                dx = nx;
                continue;
            }
            if(isValid(ny,nx) && tempMap[ny][nx] != 0){
                nextJaws.val = jaws.val+tempMap[ny][nx];
                System.out.println(tempMap[ny][nx]+"<< tempMap[ny][nx]");
                nextJaws.direct = flist.get(tempMap[ny][nx]).direct;
                nextJaws.dy = ny;
                nextJaws.dx = nx;
                tempFish = flist.remove(tempMap[ny][nx]);
                tempMap[ny][nx] = -1;
                tempMap[jaws.dy][jaws.dx] = 0;
                copyArr(tempMap,nextMap);
                copyHash(flist,nextHash);
                solution(nextMap,nextHash,nextJaws);
                flist.putIfAbsent(tempFish.val,tempFish);
                tempMap[ny][nx] = tempFish.val;
                tempMap[jaws.dy][jaws.dx] = -1;
            }
            dy=ny;
            dx=nx;
        }
        ans = Math.max(ans,jaws.val);
    }
    public static void copyHash(HashMap<Integer,FishInfo> a, HashMap<Integer,FishInfo> b){
        for(int i : a.keySet()){
            b.put(i,a.get(i));
        }
    }
    public static void copyArr(int[][] a, int[][] b){
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                b[i][j] = a[i][j];
            }
        }
    }
    public static void print(int[][] arr){
        for(int i=0; i<4; i++) {
            for(int j=0; j<4; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
class FishInfo{
    int val;
    int direct;
    int dy;
    int dx;
    public FishInfo(int val, int direct, int dy, int dx){
        this.val=val;
        this.direct=direct;
        this.dy=dy;
        this.dx=dx;
    }
}


