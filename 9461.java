import java.math.BigInteger;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int arr[];
    //int로 하면 범위 넘어감
    static long result[];
    public static long padoban(int n){
        if(result[n]!=0) return result[n];
        result[n] = padoban(n-1) + padoban(n-5);
        return result[n];
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        arr = new int[n+1];
        result = new long[101];
        //result[0] = 1;
        result[1] = 1;
        result[2] = 1;
        result[3] = 1;
        result[4] = 2;
        result[5] = 2;
        result[6] = 3;


        for(int i =1;i<=n;i++){
            arr[i] = s.nextInt();
        }
        for(int i =1;i<=n;i++){
            System.out.println(padoban(arr[i]));
        }
    }

}
