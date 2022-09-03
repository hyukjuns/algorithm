package dev_matching_2020;

public class solution2 {
    private static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};


    public static int solution(int[][] office, int r, int c, String[] move) {
        int sum = office[r][c];
        office[r][c]=0;
        int ny,nx;
        int cury=r,curx=c;
        int direct = 3;
        for(String s : move){
            if(s.equals("go")){
                ny = cury + dir[direct][0];
                nx = curx + dir[direct][1];
                if(ny < 0 || ny >= office.length || nx < 0 || nx >= office.length || office[ny][nx] == -1)
                    continue;
                cury = ny;
                curx = nx;
            }
            else if(s.equals("left")){
                direct = direct-1;
                if(direct==-1){
                    direct=3;
                }
            }
            else if(s.equals("right")){
                direct = direct+1;
                if(direct==4){
                    direct=0;
                }
            }
            sum += office[cury][curx];
            office[cury][curx] = 0;
        }
        return sum;
    }
    public static void main(String[] args) {
        int[][] office = {{5,-1,4},{6,3,-1},{2,-1,1}};
        int r = 1;
        int c = 0;
        String[] move = {"go","go","right","go","right","go","left","go"};
        System.out.println(solution(office,r,c,move));


    }
}
