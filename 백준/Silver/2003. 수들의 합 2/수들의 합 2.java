import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int arr[] = new int[n];
        String input2[] = br.readLine().split(" ");
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(input2[i]);
        }
        int l=0;
        int r=0;
        int sum =0;
        int result=0;
        while(r<n){
            sum+=arr[r];
            r++;
            while(sum>m){
                sum-=arr[l];
                l++;
            }
            if(sum==m) result++;
        }
        System.out.println(result);
    }
}
