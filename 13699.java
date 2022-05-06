import java.math.BigInteger;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static BigInteger result[];
    public static BigInteger func(int n){
        if(result[n] != null) return result[n];
        BigInteger sum = BigInteger.ZERO;
        for (int i =0;i<n;i++){
            BigInteger s = func(i).multiply(func(n-1-i));
            sum=sum.add(func(i).multiply(func(n-1-i)));
        }
        result[n]= sum;
        return result[n];
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        result = new BigInteger[n+1];
        result[0] = BigInteger.ONE;
        System.out.println(func(n));
    }

}
