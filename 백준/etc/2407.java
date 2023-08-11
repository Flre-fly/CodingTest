
import java.math.BigInteger;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static BigInteger arr[][];
    public static BigInteger combination(int n, int r){
        /*이풀이는 시간이 너무많이 걸림
        if(n==r || r == 0) return 1;
        if(r==1) return n;
        return combination(n-1,r-1) + combination(n-1, r);*/

        /*이 풀이는 숫자가 너무 커짐
        int up = 1;
        int down = 1;
        for (int i=0;i<r;i++){
            up *= n--;
        }
        for(int i = r;i>=1;i--){
            down *= i;
        }
        return up/down;*/

        /*
        이풀이도 100C50 하면 범위 넘어서서 오류남
        if(n==r || r == 0) return 1;
        if(r==1) return n;
        if(arr[n][r]!=0) return arr[n][r];
        arr[n][r] = combination(n-1,r-1) + combination(n-1, r);
        return arr[n][r];*/
        if(n==r || r == 0) return BigInteger.ONE;
        if(r==1) return BigInteger.valueOf(n);
        if(arr[n][r]!=null) return arr[n][r];
        arr[n][r] = combination(n-1,r-1).add(combination(n-1, r));
        return arr[n][r];
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int r = s.nextInt();
        arr = new BigInteger[n+1][r+1];
        System.out.println(combination(n,r));

    }

}

