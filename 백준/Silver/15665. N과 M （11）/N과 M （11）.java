import java.io.*;
import java.util.*;

public class Main {
    static int arr[];
    static int n;
    static int m;
    static int result[];
    static StringBuilder sb = new StringBuilder();
    static void permutation(int cnt){
        if(cnt == m){
            for(int i: result){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=0;i<arr.length;i++){
                result[cnt] = arr[i];
                permutation(cnt+1);
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        Set<Integer> set = new HashSet<>();
        String input2[] = br.readLine().split(" ");
        for(int i=0;i<n;i++){
            set.add(Integer.parseInt(input2[i]));
        }
        arr = new int[set.size()];
        result = new int[m];
        int j=0;
        for(Integer i: set){
            arr[j++]=i;
        }
        n = set.size();
        permutation(0);
        System.out.println(sb);
    }
}
