import org.w3c.dom.Node;

import java.lang.reflect.Array;
import java.util.*;

//2178

public class Main {
    static Integer a[];
    static Integer b[];
    static int order[];
    static int newArr[];
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        a = new Integer[n];
        b = new Integer[n];
        order = new int[n];
        newArr = new int[n];
        for(int i=0;i<n;i++){
            a[i] = s.nextInt();
        }
        for(int i=0;i<n;i++){
            b[i] = s.nextInt();
        }
        //오름차순으로
        Arrays.sort(a, Collections.reverseOrder());
        Arrays.sort(b);
        int sum = 0;
        for(int i =0;i<n;i++){
            sum += a[i] * b[i];
        }
        System.out.println(sum);


    }

}
