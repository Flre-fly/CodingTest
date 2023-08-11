import java.awt.*;
import java.util.Scanner;

public class EX1 {
    static int [][]arr;
    static int white = 0;
    static int blue = 0;
    public static void divibePaper(int row, int col, int n){
        if(ColorCheck(row,col,n)){
            //그러면 배열에 저장한다.
            if(arr[row][col] == 1) blue++;
            else white++;
        }
        else{
            //네개로 나눠서 넣어줘야돼
            divibePaper(row, col, n/2);
            divibePaper(row + n/2, col, n/2);
            divibePaper(row, col + n/2, n/2);
            divibePaper(row + n/2, col + n/2 ,n/2);
        }
    }
    public static boolean ColorCheck(int row, int col, int n){
        for(int i=row;i<row+n;i++){
            for(int j=col;j<col+n;j++){
                if(arr[i][j] != arr[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        divibePaper(0,0, n);
        System.out.println(white);
        System.out.println(blue);


    }
}