
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    static int arr[];

    public static int beOne(int n){
        if(n==0||n==1||arr[n]!=0) return arr[n];


        if(n%3 ==0){
            if(n%2==0){
                if(beOne(n/2) > beOne(n/3)){
                    if(beOne(n/3) > beOne(n-1)) {
                        arr[n] = beOne(n-1)+1;
                    }
                    else {
                        arr[n] = beOne(n/3)+1;
                    }
                }
                else{
                    //arr[n/3] > arr[n/2]
                    if(beOne(n/2) >  beOne(n-1)) {
                        arr[n] = beOne(n-1)+1;
                    }
                    else{//arr[n/2] < arr[n-1]
                        arr[n] = beOne(n/2)+1;
                    }
                }
            }
            else{
                if(beOne(n/3) >  beOne(n-1)) {
                    arr[n] = beOne(n-1)+1;
                }
                else {
                    arr[n] = beOne(n/3)+1;
                }
            }

        }
        else{
            if(n%2 ==0){
                if(beOne(n/2) < beOne(n-1)){
                    arr[n] = beOne(n/2)+1;
                }
                else{
                    arr[n] = beOne(n-1)+1;
                }
            }
            else{
                arr[n] = beOne(n-1)+1;
            }
        }
        return arr[n];
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 0;

        System.out.println(beOne(n));
        int ns = 2;
    }

}

