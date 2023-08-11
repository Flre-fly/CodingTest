import java.util.Scanner;

public class Main {
    static long arr[][] = new long[30][30];
    public static long site(int a, int b){

        if(a==b) arr[a][b] = 1;
        if(b==0) arr[a][b] = 1;
        if(arr[a][b] != 0) return arr[a][b];
        else{
            arr[a][b] = site(a-1,b-1) + site(a-1, b);
        }
        return arr[a][b];
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int a,b;
        long sum[] = new long[n];


        for(int i =0;i<n;i++){
            a = s.nextInt();
            b = s.nextInt();
            sum[i] = site(b,a);
        }
        for(int i =0;i<n;i++){
            System.out.println(sum[i]);
        }

    }
}
