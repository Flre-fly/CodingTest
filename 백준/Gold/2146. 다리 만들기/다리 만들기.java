import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int dx[] = {0,0,1,-1};
    static int dy[] = {1,-1,0,0};
    static int map[][];
    static boolean visited[][];
    static int bfs(int r, int c,int cnt){
        //한점에서만 bfs를 진행할거기때문에 visited배열을 매번 초기화 해주어야한다
        temp[r][c] = true;
        visited = new boolean[n][n];
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r,c,0));
        while(!q.isEmpty()){
            //size 만큼 반복해주는 행위 = class에 len이라는 필드추가하는것과 같음
            Point cur = q.poll();
            //1x1의 예외상황을 처리하기 위함
            visited[cur.r][cur.c] = true;

            for(int i=0;i<4;i++){
                int rr = cur.r + dx[i];
                int cc = cur.c + dy[i];
                if(rr>=n||cc>=n||rr<0||cc<0||visited[rr][cc]) continue;
                //방문안한 점인데 0이면 그쪽으로 탐색을 진행한다. 그러다가 다른 지역을 만나면 result(time) 을 반환한다
                if(map[rr][cc]==0){
                    visited[rr][cc] = true;
                    q.add(new Point(rr,cc,cur.t+1));
                    //map[rr][cc]가 0 도 아니고 cnt도 아니라면 다른 대륙이다
                    //time의 최소시간을 return해주자
                }else if(map[rr][cc] != cnt){
                    return cur.t;
                }else{
                   //추가
                   temp[rr][cc] = true;
                }

            }
        }
        return Integer.MAX_VALUE;

    }
    //map에 있는 대륙의 개수를 count한다
    static void typeCheck(int row, int col, int type){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(row, col,0));
        temp[row][col] = true;
        map[row][col] = type;

        while(!q.isEmpty()){
            Point vertex = q.poll();

            for(int i = 0; i<4; i++){
                int dr = vertex.r + dx[i];
                int dc = vertex.c + dy[i];

                if(dr<0||dc<0||dr>=n||dc>=n)
                    continue;
                if(map[dr][dc] == 0)
                    continue;
                if(temp[dr][dc])
                    continue;

                temp[dr][dc] = true;
                map[dr][dc] = type;
                q.offer(new Point(dr, dc,0));
            }
        }
    }
    static class Point{
        int r;
        int c;
        int t;
        Point(int r, int c, int t){
            this.r=r;
            this.c=c;
            this.t=t;
        }
    }
    static boolean temp[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; j<n; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }
        //각섬을 섬1, 섬2, 섬3으로 구분한다
        int type =1;
        temp = new boolean[n][n];
        for(int i =0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(map[i][j] == 0||temp[i][j]) continue;

                typeCheck(i, j, type++);
            }
        }
        int min = Integer.MAX_VALUE;
        temp = new boolean[n][n];
        for(int i =0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(map[i][j] == 0||temp[i][j]) continue;
                //한점에 대해서 bfs 탐색을한다
                //한점에 대해서만 탐색하니 여러 점에 의한 탐색 충돌이 안발생한다
                temp[i][j] = true;
                min = Math.min(min,bfs(i,j,map[i][j]));
            }
        }
        //가장 짧은 다리 출력
        System.out.println(min);


    }

}
