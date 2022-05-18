import org.w3c.dom.Node;

import java.util.*;

//2178

public class Main {
    static String arr[];
    static int n;
    static int m;
    static int visited[][];
    static int addX[] = {1,2,1,2,-2,-2,-1,-1};
    static int addY[] = {2,1,-2,-1,-1,1,2,-2};
    static int count = 0;
    public static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void nite(int n, Point player, Point goal){
        Queue<Point> q = new LinkedList<>();
        q.add(player);
        visited[player.y][player.x] = 0;
        while(!q.isEmpty()){
            Point point = q.poll();
            count++;
            if(point.x==goal.x&& point.y== goal.y) {
                return;
            }
            for(int i =0;i<8;i++){
                int x = addX[i] + point.x;
                int y = addY[i] + point.y;

                if(x>=0&&y>=0&&x<n&&y<n&&(visited[y][x]==0)){
                    q.add(new Point(x,y));
                    visited[y][x] = visited[point.y][point.x] + 1;

                }
            }

        }
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i =0;i<t;i++){
            count = 0;
            int n = s.nextInt();
            visited = new int[n][n];
            int playerX = s.nextInt();
            int playerY = s.nextInt();
            int goalX = s.nextInt();
            int goalY = s.nextInt();
            nite(n, new Point(playerX, playerY), new Point(goalX, goalY));
            System.out.println(visited[goalY][goalX]);
        }


    }

}
