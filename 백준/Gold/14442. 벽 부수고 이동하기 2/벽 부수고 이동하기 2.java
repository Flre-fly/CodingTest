import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int miro[][];
    static boolean visited[][][];
    static int dx[] = {0,0,1,-1};
    static int dy[] = {1,-1,0,0};
    static class Point{
        int r;
        int c;
        int k;
        int t;
        Point(int r, int c, int k, int t){
            this.r=r;
            this.c=c;
            this.k=k;
            this.t=t;
        }
    }
    static int bfs(){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0,0,0,1));
        int min = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            Point cur = q.poll();
            visited[cur.r][cur.c][cur.k] = true;
            if(cur.r==r-1 && cur.c==c-1) return cur.t;
            for(int i=0;i<4;i++){
                int rr = cur.r+dx[i];
                int cc = cur.c+dy[i];
                if(rr>=r|| cc>=c|| rr<0|| cc<0) continue;
                if(rr==r-1 && cc==c-1) return cur.t+1;
                if(miro[rr][cc]==0){
                    if(!visited[rr][cc][cur.k]){
                        visited[rr][cc][cur.k] = true;
                        q.add(new Point(rr,cc,cur.k, cur.t+1));
                    }

                }else{
                    if(cur.k<k &&!visited[rr][cc][cur.k+1]){//이 경우에만 최소 한번만 갈수있음
                        visited[rr][cc][cur.k+1] = true;
                        q.add(new Point(rr,cc,cur.k+1, cur.t+1));
                    }
                }
            }
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
    static int r;
    static int c;
    static int k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        r = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);
        k = Integer.parseInt(input[2]);
        visited = new boolean[r][c][k+1];
        miro = new int[r][c];
        for(int i=0;i<r;i++){
            char arr[] = br.readLine().toCharArray();
            for(int j=0;j<c;j++){
                miro[i][j] = arr[j]-'0';
            }
        }
        System.out.print(bfs());
    }

}
