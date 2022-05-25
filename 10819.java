import java.util.*;
import java.io.*;
public class Main{
    static int n;
    static int arr[];
    static int result[];
    static boolean visited[];
    static int result2;
    public static void dfs(int count){
        if(count == n){
            int sum =0;
            for(int i=0;i<result.length-1;i++){
                sum += Math.abs(result[i] - result[i+1]);
            }
            result2=Math.max(result2, sum);
            return;
        }
        //아닌경우에는.. 순서를 바꿔준다
        for(int i=0;i<n;i++){
            if(!visited[i]){
                visited[i] = true;
                result[count]=arr[i];
                dfs(count+1);
                visited[i] = false;
            }

        }

    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        arr = new int[n];
        result = new int[n];
        visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        dfs(0);
        System.out.println(result2);
    }
}