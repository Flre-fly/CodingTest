import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static void dfs(int i, int j){
        visited[i][j] = true;

        for(int k=0;k<4;k++){
            int rr = i+ dx[k];
            int cc = j+ dy[k];
            if(rr>=r||cc>=c||rr<0||cc<0|| visited[rr][cc]) continue;
            //주변에 0 이있으면 map을 감소시킨다
            if(snow[rr][cc]==0){
                if(snow[i][j]>0) snow[i][j]--;
            }
            else{
                visited[rr][cc] = true;
                dfs(rr,cc);
            }
            //주변에 1이상이 있으면 dfs 에 넣는다
        }
    }
    static int r;
    static int c;
    static int dx[] = {0,0,1,-1};
    static int dy[] = {1,-1,0,0};
    static int snow[][];
    static boolean visited[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String input[] = br.readLine().split(" ");
            r = Integer.parseInt(input[0]);
            c = Integer.parseInt(input[1]);
            snow = new int[r][c];
            for(int i=0;i<r;i++) {
                String input2[]= br.readLine().split(" ");
                for(int j=0;j<c;j++) {
                    snow[i][j] = Integer.parseInt(input2[j]);
                }
            }

            int result = 0;
            int time=0;
            while(true){
                int count =0;
                visited = new boolean[r][c];
                for(int i=0;i<r;i++) {
                    for(int j=0;j<c;j++) {
                        if(!visited[i][j] && snow[i][j]>=1){
                            dfs(i,j);
                            count++;
                        }
                    }
                }
                if(count==0){
                    break;
                }
                if(count > 1){
                    result = time;
                    break;
                }
                time++;
            }
            System.out.print(result);

    }

}
