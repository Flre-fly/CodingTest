import com.sun.jdi.IntegerValue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int arr[][];
    static int n;
    static int dfsCount = 0;
    static int bfsCount = 0;
    static boolean visited[];
    public static void dfs(int k){
        if(visited[k]) return;
        visited[k] = true;
        System.out.print(k + " ");
        //방문하지 않았고
        for(int i =0;i<=n;i++){
            if(arr[k][i]==1&&!visited[i]) {
                dfs(i);
            }
        }
    }
    public static void bfs(int k){
        visited[k] = true;

        Queue<Integer> q = new LinkedList<Integer>();
        q.add(k);
        while(q.size() != 0){
            int current =q.poll();
            System.out.print(current + " ");
            for(int i =1;i<=n;i++){
                if(arr[current][i]==1&&!visited[i]) {

                    q.add(i);
                    visited[i] = true;
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();//정점 개수
        arr = new int[n+1][n+1];
        visited = new boolean[n+1];
        int m = sc.nextInt();//간선개수
        int v = sc.nextInt();//탐색시작 정점번호
        for(int i =0;i<m;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr[x][y] = arr[y][x] = 1;
        }
        dfs(v);
        visited = new boolean[n+1];
        System.out.println();
        bfs(v);

    }
}
