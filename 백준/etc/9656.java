import java.math.BigInteger;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        if(n%2==0) System.out.println("SK");
        else System.out.println("CY");
    }

}
