import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);//같은게 s이하로 있어야함
        int arr[] = new int[n];
        String input2[] = br.readLine().split(" ");
        int m = 0;
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(input2[i]);
            m = Math.max(m, arr[i]);
        }
        int count[] = new int[m+1];
        int l=0;
        int r=0;
        int max = Integer.MIN_VALUE;//수열의 최장 길이
        while(r<n){
            count[arr[r]]++;
            while(count[arr[r]] > s){
                //s개를 초과하면 s개를 안초과할때까지 수열길이를 줄여준다
                //s는 1보다 크고 배열에 존재하는 값은 1개이상 존재할것이니 범위초과발생안함
                count[arr[l++]]--;
            }
            max = Math.max(max, r-l+1);
            r++;

        }


        System.out.print(max);
    }
}
