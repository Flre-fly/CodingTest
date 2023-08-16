import java.io.*;
import java.util.*;

public class Main {
    static class Point{
        int l;
        int r;
        int c;
        int t;
        Point(int l, int r, int c, int t){
            this.l=l;
            this.r=r;
            this.c=c;
            this.t=t;
        }
    }
    static int l;
    static int r;
    static int c;
    static int dx[] = {0,0,1,-1,0,0};
    static int dy[] = {1,-1,0,0, 0,0};
    static int dz[] = {0,0,0,0,1,-1};
    static boolean visited[][][];
    static int bfs(Point start){
        Queue<Point> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            Point cur = q.poll();

            for(int i=0;i<6;i++){
                int ll = cur.l + dz[i];
                int rr = cur.r + dx[i];
                int cc = cur.c + dy[i];
                if(ll>=l || rr>=r || cc>=c || ll<0 || rr<0 || cc<0 || building[ll][rr][cc]=='#') continue;
                if(building[ll][rr][cc]=='E') return cur.t+1;
                if(!visited[ll][rr][cc]){
                    visited[ll][rr][cc] = true;
                    q.add(new Point(ll,rr,cc, cur.t+1));
                }

            }
        }
        return -1;
    }
    static char building[][][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String input[] = br.readLine().split(" ");
            l = Integer.parseInt(input[0]);
            r = Integer.parseInt(input[1]);
            c = Integer.parseInt(input[2]);
            if(l==r && r==c && c==0) {
                return;
            }
            building = new char[l][r][c];
            visited = new boolean[l][r][c];
            Point start = null;
            for(int i=0;i<l;i++){
                for(int j=0;j<r;j++){
                    char input2[] = br.readLine().toCharArray();
                    for(int k=0;k<c;k++){
                        building[i][j][k] = input2[k];
                        if(building[i][j][k]=='S'){
                            start = new Point(i,j,k,0);
                            building[i][j][k] = '.';
                        }
                    }
                }
                br.readLine();
            }
            int time = bfs(start);
            if(time==-1){
                System.out.println("Trapped!");
                continue;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Escaped in ").append(time).append(" minute(s).");
            System.out.println(sb);
        }


    }

}
