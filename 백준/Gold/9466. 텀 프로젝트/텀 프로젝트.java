import java.io.*;

public class Main {
    static void dfs(int start){
        if(visited[start]){
            finished[start] = true;
            count++;
        }else visited[start] = true;

        int next = arr[start];
        if(!finished[next]) dfs(next);

        visited[start] = false;
        // DFS 재귀 호출이 끝나면 visited 상태를 되돌려야 다음 경로에서 해당 노드가 다시 첫 방문으로 간주될 수 있습니다.
        finished[start] = true;
        //finished 배열은 노드가 완전히 처리되었는지 여부를 추적합니다.
        // 노드가 완전히 처리되었다는 것은 그 노드를 시작으로 하는 모든 경로가 이미 탐색되었다는 의미입니다.
        // 순환 구조가 발견되지 않은 경우에도, 해당 노드와 관련된 모든 탐색이 완료된 상태이므로 finished를 true로 설정합니다.
    }
    static int arr[];
    static int n;
    static int count;
    static boolean visited[];
    static boolean finished[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            n = Integer.parseInt(br.readLine());
            visited = new boolean[n+1];
            count=0;
            finished = new boolean[n+1];
            arr = new int[n+1];
            String input[] = br.readLine().split(" ");
            for(int j=1;j<=n;j++){
                arr[j] = Integer.parseInt(input[j-1]);
            }
            for(int j=1;j<=n;j++){
                if(!finished[j]) dfs(j);
            }
            System.out.println(n-count);
        }
    }

}
