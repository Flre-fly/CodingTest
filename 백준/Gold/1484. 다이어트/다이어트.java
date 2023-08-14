import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int n = Integer.parseInt(br.readLine());
        //x2 = y2  + n
        //y2 = n-x2
        //y2+n은 제곱수여야함
        boolean no = true;
        for(int i=1;i<=100000;i++){
            long y2 = (long)(Math.pow(i,2)-n);
            if(Math.pow((int)Math.sqrt(y2),2) == y2 && y2!=0){//제곱수인 경우
                System.out.println(i);
                no = false;
            }
        }
        if(no) System.out.println(-1);
    }

}
