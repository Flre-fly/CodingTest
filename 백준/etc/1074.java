import java.awt.*;
import java.util.Scanner;

public class EX1 {
    static long visit = 0;
    public static void Z(long n, long row, long col){
        if(n==1){
            System.out.println(visit);
        }
        //재귀적으로 방문할거야 4등분을해서..
        else{
            if(row < n/2 && col <n/2){//1사분면
                Z(n/2, row, col);
            }
            else if(row >= n/2 && col < n/2){//3사분면
                visit += (n*n/2);
                Z(n/2, row-n/2, col);

            }
            else if( row < n/2 && col >= n/2){//2사분면
                visit += (n*n/4);
                Z(n/2, row, col-n/2);
            }
            else{//4사분면
                visit += n*n * 3/4;
                Z(n/2, row-n/2, col - n/2);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        long r = sc.nextInt();
        long c = sc.nextInt();
        n = (long)Math.pow(2,n);
        Z(n,r,c);


    }
}