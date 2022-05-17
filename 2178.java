import org.w3c.dom.Node;

import java.util.*;

//2583

public class Main {
    static String arr[];
    static int n;
    static int m;
    static int count[][];
    static boolean visited[][];
    static int addX[] = {0,1,-1,0};
    static int addY[] = {1,0,0,-1};
    public static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static void maze(){
        //(1,1)에서 출발
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0,0));
        count[0][0] = 1;//시작위치는 일단 count한다
        visited[0][0] = true;//시작 위치는 방문했다고 가정
        while(!q.isEmpty()){
            Point point = q.poll();
            //들어온 이 point를 기준으로 상하좌우 탐색을 시작한다
            for(int i =0;i<4;i++){
                int x = addX[i] + point.x;
                int y = addY[i] + point.y;
                if(x>=0&&y>=0&&x<m&&y<n&&arr[y].charAt(x)=='1'&&!visited[y][x]) {
                    count[y][x] = count[point.y][point.x] + 1;
                    visited[y][x] = true;
                    q.add(new Point(x,y));
                }
            }
        }

    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        m = s.nextInt();
        arr = new String[n];
        count= new int[n][m];
        visited = new boolean[n][m];
        for(int i=0;i<n;i++){
            arr[i] = s.next();
        }
        maze();
        System.out.println(count[n-1][m-1]);


    }

}
