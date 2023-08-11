import java.math.BigInteger;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    // set의 자료 구조를 사용하는 것이다.
    // set은 중복된 값을 중복 저장할 수 없기 때문에
    //중복된 값은 자동으로 처리해 중복되지 않은 //데이터만 저장된다. (다른 set 구조를 사용해도 된다.)

    static int arr[][];
    static boolean visited[];
    static int max = 0;
    static int n;
    static int count = 0;
    static void dfs(int k){
        if(visited[k]) return;

        count++;
        visited[k] = true;

        //n번 노드에 대해 dfs를 한다
        for(int i =0;i<=n;i++){// 여기서 i<n으로 하면 오답이 나온다 n까지 탐색해주어야한다
            if(arr[k][i]==1 && !visited[i]){//방문도 안했고 둘이 이어져있다면
                //count++, visited[k] = true를 여기서 해주면 안된다
                //위의 조건에 부합할 경우는 더탐색해야하는거고 count랑visited는 인자로 넘어온 k에 대해서 해주어야한다
                dfs(i);//i에 대해서 더 탐색

            }
        }
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        n = s.nextInt();//컴퓨터 수
        arr = new int[n+1][n+1];//노드 1을 노드 1이라고 표현하기 위해서
        visited = new boolean[n+1];
        int j = s.nextInt();//직접 연결되어있는 컴퓨터 쌍
        for(int i =0;i<j;i++){
            int x = s.nextInt();
            int y = s.nextInt();
            arr[y][x] = arr[x][y] = 1;//(x,y)연결됨을 의미 (방향x)
        }
        dfs(1);
        System.out.println(count-1);




    }

}
