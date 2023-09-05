import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int arr[][];
    static int result[][];

    public static void recursive(){
        result[0][0] = arr[0][0];
        result[0][1] = arr[0][1];
        result[0][2] = arr[0][2];
        for(int i=1;i<arr.length;i++){
            for(int j=0;j<3;j++){
                if(j%3==0){
                    result[i][j] = arr[i][j] + Math.min(result[i-1][1], result[i-1][2]);
                }else if(j%3==1){
                    result[i][j] = arr[i][j] + Math.min(result[i-1][0], result[i-1][2]);
                }else{
                    result[i][j] = arr[i][j] + Math.min(result[i-1][1], result[i-1][0]);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][3];
        result = new int[n][3];
        for(int i=0;i<n;i++){
            String input[] = br.readLine().split(" ");
            for(int j=0;j<3;j++){
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        recursive();
        System.out.println(Math.min(Math.min(result[n-1][0], result[n-1][1]), result[n-1][2]));

    }

}
