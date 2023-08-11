import java.io.*;
import java.util.*;


public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int sum = Integer.parseInt(input[1]);
        int arr[] = new int[n];
        String input2[] = br.readLine().split(" ");
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(input2[i]);
        }
        int l = 0;
        int r = 0;
        int result = 0;
        int count = 0;
        while(l < n) { // 조건 변경
            if(result < sum && r < n) { // r이 n에 도달하지 않았을 때만 값을 더합니다.
                result += arr[r];
                r++;
            } else {
                result -= arr[l];
                l++;
            }

            if(sum == result) count++;
        }
        System.out.print(count);

    }
}