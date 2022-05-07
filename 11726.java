import java.math.BigInteger;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int result[];
    public static int func(int n){
        if(result[n]!=0) return result[n];
        result[n] = (func(n-1) + func(n-2))%10007;
        return result[n];
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        result = new int[1001];
        result[1] = 1;
        result[2] = 2;
        System.out.println(func(n));
    }

}
