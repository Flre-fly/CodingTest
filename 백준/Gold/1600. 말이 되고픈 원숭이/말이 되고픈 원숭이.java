import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int r;
    static int c;
    static int k;
    static int dx[] = {0,0,1,-1};
    static int dy[] = {1,-1,0,0};
    static int hx[] = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int hy[] = {1, 2, 2, 1, -1, -2, -2, -1};
    static int map[][];
    static boolean visited[][][];
    static int bfs(){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0,0, k));
        int time=0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size>0){
                Point cur = q.poll();
                visited[cur.r][cur.c][cur.k] = true;
                if(cur.r==r-1 && cur.c==c-1) return time;
                //상하좌우
                for(int i=0;i<dx.length;i++){
                    int rr = cur.r + dx[i];
                    int cc = cur.c + dy[i];
                    if(rr>=r||cc>=c||rr<0||cc<0) continue;
                    if(!visited[rr][cc][cur.k] && map[rr][cc]==0){
                        q.add(new Point(rr,cc, cur.k));
                        visited[rr][cc][cur.k] = true;
                    }
                }
                if(cur.k>0){
                    for(int i=0;i<hx.length;i++){
                        int rr = cur.r + hx[i];
                        int cc = cur.c + hy[i];
                        if(rr>=r||cc>=c||rr<0||cc<0) continue;
                        if(!visited[rr][cc][cur.k-1] && map[rr][cc]==0){
                            q.add(new Point(rr,cc, cur.k-1));
                            visited[rr][cc][cur.k-1] = true;
                        }
                    }
                }
                size--;
            }
            time++;

        }

        return -1;
    }
    static class Point{
        int r;
        int c;
        int k;//내가 사용할 수있는 말의 움직임횟수
        Point(int r, int c, int k){
            this.r=r;
            this.c=c;
            this.k=k;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        String input[] = br.readLine().split(" ");
        c = Integer.parseInt(input[0]);
        r = Integer.parseInt(input[1]);
        map = new int[r][c];
        visited = new boolean[r][c][k+1];
        for(int i=0;i<r;i++) {
            String input2[]= br.readLine().split(" ");
            for(int j=0;j<c;j++) {
                map[i][j] = Integer.parseInt(input2[j]);
            }
        }
        System.out.println(bfs());


    }

}
