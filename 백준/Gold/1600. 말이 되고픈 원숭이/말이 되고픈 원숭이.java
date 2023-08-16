import java.io.*;
import java.util.*;

public class Main {
    static class Point{
        int r;
        int c;
        int t;
        int count;
        Point(int r, int c, int t, int count){
            this.r=r;
            this.c=c;
            this.t=t;
            this.count = count;
        }
    }
    static int dx[] = {0,0,1,-1};
    static int dy[] = {1,-1,0,0};
    static int dx2[] = {2, 1, -2, -1, 2, 1, -2, -1};
    static int dy2[] = { 1, 2, 1, 2, -1, -2, -1, -2};
    static boolean visited[][][];
    static int bfs(){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0,0,1, k));
        int min = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            Point cur = q.poll();
            for(int i=0;i<dx.length;i++){
                int rr = cur.r+dx[i];
                int cc = cur.c+dy[i];
                if(rr>=r || cc>=c || rr<0 || cc<0 || map[rr][cc]==1) continue;
                if(rr==r-1 && cc==c-1) min = Math.min(min, cur.t);
                if(!visited[rr][cc][cur.count]){
                    visited[rr][cc][cur.count] = true;
                    q.add(new Point(rr,cc, cur.t+1, cur.count));
                }
            }
            if(cur.count>0){
                for(int i=0;i<dx2.length;i++){
                    int rr = cur.r+dx2[i];
                    int cc = cur.c+dy2[i];
                    if(rr>=r || cc>=c || rr<0 || cc<0 || map[rr][cc]==1) continue;
                    if(rr==r-1 && cc==c-1) min = Math.min(min, cur.t);
                    if(!visited[rr][cc][cur.count-1]){
                        visited[rr][cc][cur.count-1] = true;
                        q.add(new Point(rr,cc, cur.t+1, cur.count-1));
                    }
                }
            }

        }
        return min;
    }
    static int map[][];
    static int k;
    static int r;
    static int c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k =Integer.parseInt(br.readLine());
        String input[] = br.readLine().split(" ");
        c = Integer.parseInt(input[0]);
        r = Integer.parseInt(input[1]);
        map = new int[r][c];
        visited =new boolean[r][c][k+1];
        for(int i=0;i<r;i++){
            String input2[] = br.readLine().split(" ");
            for(int j=0;j<c;j++){
                map[i][j] = Integer.parseInt(input2[j]);
            }
        }
        if(c==r && r==1) System.out.print("0");
        else{
            int time = bfs();
            System.out.print(time==Integer.MAX_VALUE?"-1":time);
        }
    }

}
