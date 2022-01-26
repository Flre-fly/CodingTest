

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    //5시 33분 시작
    public static void main(String[] args) {
        int n;//전체 사람의 수
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int [][]info = new int[2][n];
        for(int i =0;i<n;i++){
            info[0][i] =  sc.nextInt();
            info[1][i] =  sc.nextInt();

        }
        int moreThan = 0;
        int []grades = new int[n];
        for(int k=0;k<n;k++){
            moreThan = 0;
            for(int i=0;i<n;i++){
                //k = 자기자신을 기준으로 loop를 돌아서 자기보다 덩치큰 놈들의 개수를 찾는다
                if(info[0][k] < info[0][i] && info[1][k] < info[1][i]){
                    moreThan++;
                }
            }
            grades[k] = moreThan+1;

        }
        for (int grade:
             grades) {
            System.out.print(grade+ " ");

        }


    }

}
