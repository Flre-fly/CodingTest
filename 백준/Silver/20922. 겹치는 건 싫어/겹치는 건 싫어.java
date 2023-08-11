import java.io.*;
import java.util.*;


public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int limit = Integer.parseInt(input[1]);
        int arr[] = new int[n];
        String input2[] = br.readLine().split(" ");
        int max = 0;
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(input2[i]);
            max = Math.max(max, arr[i]);
        }
        int count[] = new int[max+1];
        int l = 0;
        int r = 0;
        int result = 0;
        //<while문의 기준이 r이되는 이유>
        //오른쪽 포인터는 처음부터 끝까지 전체 시퀀스를 통해 이동합니다. 모든 번호를 하나씩 확인합니다.
        //왼쪽 포인터는 현재 창에서 숫자가 K번 이상 나타날 때만 움직입니다. 이 경우 왼쪽은 오른쪽으로 이동하여 반복되는 숫자를 제외합니다.
        //시퀀스의 모든 숫자를 확인하려고 하므로 오른쪽이 시퀀스(N)의 끝에 도달하지 않는 한 루프는 계속됩니다.
        while(r<n){
            if(count[arr[r]]+1 <= limit){
                count[arr[r]]++;
                r++;
            }else{
                count[arr[l]]--;
                l++;
            }
            result = Math.max(result, r-l);
        }
        System.out.print(result);

    }
}