import java.io.*;

public class Main {
    static void dfs(int start){
        if(visited[start]){
           finished[start] = true;
           count++;
        }else visited[start] = true;

        int next = arr[start];
        if(!finished[next]) dfs(next);//순환이 있는지 조사해본다
        //dfs가 끝나고 나서
        visited[start] = false;//매번 dfs마다 visited는 새로워야함
        finished[start] = true;//한번의 dfs마다 start에 대한 조사는 완료됨

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
