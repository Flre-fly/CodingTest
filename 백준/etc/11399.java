import java.math.BigInteger;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int arr[];
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = s.nextInt();
        }
        //정렬
        arr=Arrays.stream(arr).sorted().toArray();
        int sum = 0;
        for (int i = 1;i<=n;i++){
            for(int k=0;k<i;k++){
                sum += arr[k];
            }
        }
        System.out.println(sum);

    }

}
