import java.math.BigInteger;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

//2583
public class Main {
    static int arr[][];
    static int count = 0;
    static int n;
    static int m;
    static boolean visited[][];
    public static void dfs(int x, int y){
        if (x < 0 || y < 0 || x >= m|| y >= n) return;
        if(visited[x][y]) return;
        count++;
        //값이 0인곳에 대해 dfs를 하는거니까..
        if (arr[x][y] ==0){
            visited[x][y] = true;

            dfs(x,y-1);
            dfs(x-1,y);
            dfs(x+1,y);
            dfs(x,y+1);
        }





    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        m = s.nextInt();
        n = s.nextInt();
        int k = s.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        arr = new int[m][n];//m : row : y, n : column : x 에 대응된다
        visited = new boolean[m][n];
        for(int i =0;i<k;i++){
            // 1,2 라는것은 첫번째줄에있는 두번째 원소를 의미한다 그니까 입력받는 순서가 y->x순서라는 의미
            int y1 = s.nextInt();
            int x1 = s.nextInt();
            int y2 = s.nextInt()-1;//이렇게 해야 둘다 n/m개의 공간으로 표현할 수 있다
            int x2 = s.nextInt()-1;
            //x:
            for(int y = y1; y<=y2;y++){
                for(int x = x1;x<=x2;x++){
                    arr[x][y] = 1;
                    visited[x][y] = true;
                }
            }
        }
        for(int y=0;y<n;y++){
            for(int x =0;x<m;x++){
                if(!visited[x][y]) {
                    dfs(x,y);
                    list.add(count);
                    count = 0;
                }
            }
        }
        System.out.println(list.size());
        Collections.sort(list);
        for (Integer i : list) {
            System.out.print(i +" ");
        }




    }

}
