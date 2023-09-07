import java.io.*;
import java.util.*;


public class Main {
    static int l;
    static int c;
    static char arr[];
    static char result[];
    static boolean visited[];
    static void combination(int cnt, int start){
        if(cnt == l){
            //체크하고 출력
            if(isResult()){
                StringBuilder sb = new StringBuilder();
                for(int i=0;i<result.length;i++){
                    sb.append(result[i]);
                }
                System.out.println(sb);
            }
            return;
        }
        for(int i=start;i<arr.length;i++){
            result[cnt] = arr[i];
            combination(cnt+1, i+1);
        }

    }
    static boolean isResult(){
        int ja =0;
        int mo =0;
        for(int i=0;i<result.length;i++){
            if(result[i]=='a'||result[i]=='e'||result[i]=='i'||result[i]=='o'||result[i]=='u'){
                mo++;
            }else ja++;
        }
        if(mo>=1 && ja >=2) return true;
        return false;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        l = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);
        arr = new char[c];
        result = new char[l];
        String input2[] = br.readLine().split(" ");
        for(int i=0;i<input2.length;i++){
            arr[i] = input2[i].charAt(0);
        }
        visited = new boolean[arr.length];
        Arrays.sort(arr);
        combination(0,0);

    }
}