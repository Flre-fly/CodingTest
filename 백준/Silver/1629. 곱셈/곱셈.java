import java.util.*;
import java.io.*;

public class Main {
    static int c;
    static long pow(int a, int b){
        if(b==1) return a%c;

        //a^b승은 결국 temp보다는 작아지게될거다
        //재귀호출을 반복하다가 최소 b=1일때 a를 return할것이니까 
        //temp의 최댓값은 결국 a의 최댓값인 21억인거다
        long temp = pow(a, b/2);

        if(b%2==0){
            //21억 x 21억은 long의 범위를 넘어가지 않으니 오버플로우가 발생하지 않는다 
            return temp* temp %c;
        }
        else{
            //아래코드에선 오버플로우가 발생할 수 있다 그래서
            //return temp * temp * a % c;
            //아래 코드로 작성해준다
            return (temp*temp %c) *a %c;
        }
    }
    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       String input[] = br.readLine().split(" ");
       int a = Integer.parseInt(input[0]);
       int b = Integer.parseInt(input[1]);
       c = Integer.parseInt(input[2]);
       System.out.println(pow(a,b));

    }
}
