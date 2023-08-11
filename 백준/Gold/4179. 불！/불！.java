import java.util.*;
import java.io.*;

public class Main {
    static Queue<Point> q = new LinkedList<>();
    static Queue<Point> jihunQ = new LinkedList<>();
    static int row;
    static int col;
    static char miro[][];
    public static int bfs(int jiR, int jiC){
        int dx[] = {0,0,1,-1};
        int dy[] = {1,-1,0,0};

        int time=0;
        int qSize = 0;
        int jSize = 0;
        while(!jihunQ.isEmpty()){
            qSize = q.size();
            while(qSize>0){
                Point cur = q.poll();
                qSize--;
                for(int i=0;i<4;i++){
                    int r = dx[i] + cur.r;
                    int c = dy[i] + cur.c;
                    if(r<0 ||c<0|| r>=row || c>=col) continue;
                    if(miro[r][c] == '.' || miro[r][c] == 'J') {
                        q.add(new Point(r,c));
                        miro[r][c] = 'F';
                    }
                }
            }
            time++;
            jSize = jihunQ.size();
            while(jSize>0){
                Point cur = jihunQ.poll();
                jSize--;
                for(int i=0;i<4;i++){
                    int r = dx[i] + cur.r;
                    int c = dy[i] + cur.c;
                    if(r<0 ||c<0|| r>=row || c>=col) return time;
                    if(miro[r][c] == '.') {
                        jihunQ.add(new Point(r,c));
                        miro[r][c] = 'J';
                    }
                }

            }
        }
        return -1;

    }
    static class Point{
        int r;
        int c;
        Point(int r, int c){
            this.r=r;
            this.c=c;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        row  = Integer.parseInt(input[0]);
        col = Integer.parseInt(input[1]);
        miro = new char[row][col];
        int curR = 0;
        int curC = 0;
        for(int i=0;i<row;i++){
            char input2[] = br.readLine().toCharArray();
            for(int j=0;j<col;j++){
                miro[i][j] = input2[j];
                if(miro[i][j]=='F') q.add(new Point(i,j));
                else if(miro[i][j]=='J') {
                    curR = i;
                    curC = j;
                    jihunQ.add(new Point(i,j));
                }
            }
        }
        int result = bfs(curR, curC);
        System.out.println(result==-1?"IMPOSSIBLE":result);
    }
}
