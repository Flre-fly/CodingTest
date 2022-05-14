import java.math.BigInteger;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static final int MAXINPUT = 12;
    static int arr[];
    static int plus123(int n){
        if(arr[n] != 0) return arr[n];
        else{
            arr[n] = plus123(n-3) + plus123(n-2) + plus123(n-1);
            return arr[n];
        }
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        arr = new int[MAXINPUT];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;
        for (int i =0;i<t;i++){
            int n = s.nextInt();
            System.out.println(plus123(n));
        }


    }

}
