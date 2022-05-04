import java.math.BigInteger;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    //1904
    static long result[];

    public static long binary(int n){
        if (result[n]!=0) return result[n];
        result[n] = (binary(n-1) + binary(n-2)) % 15746;
        return result[n];
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        result = new long[1000001];
        result[0] = 0;
        result[1] = 1;
        result[2] = 2;
        System.out.println(binary(n));
    }

}
