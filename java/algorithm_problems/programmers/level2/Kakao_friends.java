package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;
import java.awt.Point;

public class Kakao_friends {
    static boolean[][] visited;
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};

    public static boolean isValid(int dy, int dx, int m, int n){
        return (dy<0 || dy>=m || dx<0 || dx>=n) ? false : true;
    }

    public static int bfs(int section, int dy, int dx, int[][] map){
       Queue<Point> q = new LinkedList<>();
       q.add(new Point(dx,dy));
       visited[dy][dx] = true;

       int areaSize=0;
       while(!q.isEmpty()){
           Point temp = q.poll();
           areaSize++;

           int ny,nx;
           for(int i=0; i<4; i++){
               ny = temp.y + dir[i][0];
               nx = temp.x + dir[i][1];
               if(isValid(ny,nx, map.length, map[0].length) && map[ny][nx] == section && !visited[ny][nx]){
                   visited[ny][nx] = true;
                   q.add(new Point(nx,ny));
               }
           }
       }
       return areaSize;
    }
    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        visited = new boolean[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(picture[i][j] != 0 && !visited[i][j]){
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(bfs(picture[i][j], i, j, picture),maxSizeOfOneArea);
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        int[][] pic = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        int[] ans = solution(m,n,pic);
        for(int i : ans){
            System.out.print(i+" ");
        }
    }
}