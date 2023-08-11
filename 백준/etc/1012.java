import java.math.BigInteger;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static boolean[][] vistied;
    static int count = 0;
    static int arr[][];
    static int m,n;
    static int[] dx = { 0, -1, 0, 1 };
    static int[] dy = { 1, 0, -1, 0 };

    static void dfs(int x, int y){
        //방문처리
        if (x<0||y<0||x>=m||y>=n) return;
        if (arr[x][y]==1 && vistied[x][y] == false) vistied[x][y] = true;
        //방문한 노드의 인접노드 찾기
        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            if (cx >= 0 && cy >= 0 && cx < m && cy < n) {
                if (!vistied[cx][cy] && arr[cx][cy] == 1) {
                    dfs(cx, cy);
                }
            }

        }
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();//test case 개수

        for(int i=0;i<t;i++){
            count = 0;
            m = s.nextInt();
            n = s.nextInt();
            int ca = s.nextInt();
            arr = new int[m][n];
            vistied = new boolean[m][n];
            for (int k=0;k<ca;k++){
                int x = s.nextInt();
                int y = s.nextInt();
                arr[x][y] = 1;
            }
            for(int a = 0;a<m;a++){
                for(int b=0;b<n;b++){
                    if (arr[a][b]==1 && vistied[a][b] == false) {
                        dfs(a,b);
                        count++;
                    }
                }
            }
            System.out.println(count);


        }
    }

}
