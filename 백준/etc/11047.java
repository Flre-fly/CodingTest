import org.w3c.dom.Node;

import java.lang.reflect.Array;
import java.util.*;

//2178

public class Main {
    static int arr[];
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int K = s.nextInt();
        arr = new int[N];
        int coin =0;
        for(int i =0;i<N;i++){
            arr[i] = s.nextInt();
        }
        //숫자 n보다는 작은수를 뽑아내는 메서드
        for(int i=N-1;i>=0;i--){
            if(arr[i] <= K){
                coin += K / arr[i];

                K = K % arr[i];
            }
        }
        System.out.println(coin);
    }

}
