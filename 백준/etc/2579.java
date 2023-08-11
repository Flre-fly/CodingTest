import java.math.BigInteger;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int arr[];
    static int result[];
    public static int stairs(int n){
        if(n<=0) return 0;
        if (result[n] != 0) return result[n];
        result[n] = Math.max(stairs(n-2) + arr[n], stairs(n-3) + arr[n-1] + arr[n]);
        return result[n];
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        arr = new int[n+1];
        result = new int[n+1];
        result[0] = 0;
        for(int i =1;i<=n;i++){
            arr[i] = s.nextInt();
        }
        stairs(n);
        System.out.println(result[n]);
    }

}
