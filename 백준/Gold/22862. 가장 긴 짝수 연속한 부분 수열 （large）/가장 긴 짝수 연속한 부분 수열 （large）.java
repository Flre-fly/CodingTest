import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       String[] input2 = br.readLine().split(" ");
       int n = Integer.parseInt(input2[0]);
       int k = Integer.parseInt(input2[1]);
       int[] arr = new int[n];
       String[] input = br.readLine().split(" ");
       for (int i = 0; i < n; i++) {
           arr[i] = Integer.parseInt(input[i]);
       }

       int l = 0;
       int r = 0;
       int result = 0;
       int temp = 0;
       int evenCount = 0;

       while (r < n) {
           if (arr[r] % 2 != 0) {
               temp++;
           } else {
               evenCount++;
           }
           while (temp > k) {
               if (arr[l] % 2 != 0) {
                   temp--;
               } else {
                   evenCount--;
               }
               l++;
           }
           result = Math.max(result, evenCount);
           r++;
       }
       System.out.print(result);
    }
}
