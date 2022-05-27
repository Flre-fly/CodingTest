import java.awt.*;
import java.util.*;
import java.io.*;
public class Main{
    static boolean visited[];
    static class Point{
        int time;
        int x;
        public Point(int x, int time){
            this.x = x;
            this.time = time;
        }
    }
    public static int bfs(int start, int end){
        if(start==end) return 0;
        Queue<Point> q = new LinkedList<>();
        int time = 1;
        q.add(new Point(start +1, time));
        q.add(new Point(start -1, time));
        q.add(new Point(start*2, time));
        visited[start] = true;
        while(!q.isEmpty()){
            Point p =q.poll();
            if(p.x <0 || p.x >= 100001) continue;
            if(visited[p.x] == true) continue;
            visited[p.x] = true;
            if(p.x == end) return p.time;
            //아닌 경우에는 계속해서 탐색을 진행한다
            q.add(new Point(p.x+1,p.time+1));
            q.add(new Point(p.x-1, p.time+1));
            q.add(new Point(p.x*2, p.time+1));
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();//수빈 위치
        int k = s.nextInt();//동생 위치
        visited = new boolean[100001];
        System.out.println(bfs(n, k));
    }
}