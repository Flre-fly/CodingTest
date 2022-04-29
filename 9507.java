import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    static long arr[] = new long[69];

    public static long koong(int n){
        if(n<2) return 1;
        if(arr[n] != 0) return arr[n];
        else {
            arr[n] = koong(n-1) + koong(n-2) + koong(n-3) + koong(n-4);
            return arr[n];
        }
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        arr[1] =1;
        arr[0] = 1;
        arr[2] = 2;
        arr[3] =4;

        for(int i =0;i<n;i++){
            int x = s.nextInt();
            System.out.println(koong(x));
        }

    }
}
