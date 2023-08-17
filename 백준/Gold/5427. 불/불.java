import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static class Point{
        int r;
        int c;
        int t;
        Point(int r, int c,int t){
            this.r=r;
            this.c=c;
            this.t=t;
        }
    }
    static int bfs(Point start){
        Queue<Point> q = new LinkedList<>();
        q.add(start);
        int time = 1;
        while(!q.isEmpty()){
            //불지른다
            int size = fire.size();
            while(size>0){
                Point cur = fire.poll();
                fireV[cur.r][cur.c] = true;

                for(int i=0;i<4;i++){
                    int rr = cur.r + dx[i];
                    int cc = cur.c + dy[i];
                    if(rr>=r || cc>=c|| rr<0||cc<0) continue;
                    if(!fireV[rr][cc] && building[rr][cc]=='.'){
                        //이 경우에만 불을 지른다
                        building[rr][cc] = '*';
                        fireV[rr][cc] = true;
                        fire.add(new Point(rr,cc,0));
                    }
                }

                size--;
            }
            size = q.size();
            //상근이 이동한다
            while(size>0){
                Point cur = q.poll();
                visited[cur.r][cur.c] = true;
                if(cur.r==0 || cur.c==0 || cur.r==r-1 || cur.c==c-1) return time;
                for(int i=0;i<4;i++){
                    int rr = cur.r + dx[i];
                    int cc = cur.c + dy[i];
                    if(rr>=r || cc>=c|| rr<0||cc<0 || building[rr][cc]!='.') continue;
                    if(rr==0 || cc==0 || rr==r-1 || cc==c-1) return time+1;
                    if(!visited[rr][cc]){
                        //이 경우에만 이동할 수 있다
                        visited[rr][cc] = true;
                        q.add(new Point(rr,cc,cur.t+1));
                    }
                }

                size--;
            }

            time++;
        }
        return -1;
    }
    static int r;
    static int c;
    static int dx[] = {0,0,1,-1};
    static int dy[] = {1,-1,0,0};
    static char building[][];
    static boolean visited[][];
    static boolean fireV[][];
    static Queue<Point> fire = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            String input[] = br.readLine().split(" ");
            c = Integer.parseInt(input[0]);
            r = Integer.parseInt(input[1]);
            visited = new boolean[r][c];
            building = new char[r][c];
            fireV = new boolean[r][c];
            fire = new LinkedList<>();
            Point start = null;
            for(int rr=0;rr<r;rr++){
                char[] arr = br.readLine().toCharArray();
                for(int cc=0;cc<c;cc++){
                    building[rr][cc] = arr[cc];
                    if(arr[cc]=='@') {
                        start = new Point(rr,cc,0);
                        building[rr][cc] = '.';
                    }
                    else if(arr[cc]=='*') fire.add(new Point(rr,cc,0));
                }
            }
            int time = bfs(start);
            System.out.println(time==-1?"IMPOSSIBLE":time);
        }
    }

}
