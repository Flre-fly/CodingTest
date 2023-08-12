import java.io.*;
import java.util.*;


public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] =br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);
        int arr[] = new int[n];
        int max = 0;
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }
        int l =0;
        int r=1;
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        while(r<n){
            int gap = arr[r] - arr[l];
            if(gap>=s && l<n-1) {
                min = Math.min(min, gap);
                l++;
            }else r++;
        }

        System.out.print(min);

    }
}