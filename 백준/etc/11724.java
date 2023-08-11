import java.math.BigInteger;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int arr[][];
    static int n;
    static boolean visited[];
    static int dfs(int k){
        if (visited[k]) return 0;
        visited[k] = true;
        for (int i =1;i<=n;i++){
            if(arr[k][i] == 1 && !visited[i]){
                dfs(i);
            }
        }
        return 1;
    }
    static void bfs(int k){
        Queue<Integer> q = new LinkedList<>();
        q.add(k);

        while(!q.isEmpty()){
            int x = q.poll();

            visited[x] = true;
            for (int i =1;i<=n;i++){
                if(arr[x][i] == 1 & !visited[i]){
                    q.add(i);
                    visited[i] = true;//이게 없으면 시간초과가 뜬다
                    //만약에 위의줄이없으면 i를 이미 큐에 넣었는데 또 넣을수가 있다는얘기
                    //계속 큐에 넣게 되면 while문을 계속 반복하게 될테니 시간초과가 뜬다
                }
            }
        }
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        n = s.nextInt();//정점개수ㄱ
        int m = s.nextInt();//간선
        arr = new int[n+1][n+1];
        visited = new boolean[n+1];
        for (int i =0;i<m;i++){
            int x = s.nextInt();
            int y = s.nextInt();
            arr[x][y] = arr[y][x] = 1;//연결되어있습니다
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                bfs(i);
                count++;
            }
        }
        System.out.println(count);


    }

}
