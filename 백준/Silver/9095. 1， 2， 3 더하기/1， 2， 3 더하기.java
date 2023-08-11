import java.io.*;
import java.util.*;


public class Main {
    static int arr[];
    static int sum;
    public static void dp(){
        for(int i=4;i<=11;i++){
            arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        arr = new int[12];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;
        dp();
        for(int i=0;i<t;i++){
            sum = Integer.parseInt(br.readLine());
            System.out.println(arr[sum]);
        }
    }
}