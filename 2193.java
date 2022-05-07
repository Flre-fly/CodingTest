import java.math.BigInteger;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static long result[];
    public static long chin2(int n){
        if(result[n]!=0) return result[n];
        result[n] = chin2(n-1) + chin2(n-2);
        return result[n];
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        result = new long[91];
        result[1] = 1;
        result[2] = 1;
        System.out.println(chin2(n));
    }

}
