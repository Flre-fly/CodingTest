import java.awt.*;
import java.util.*;
import java.io.*;
public class Main{
    public static Set<String> set;
    public static void lineSplit(int k, String line){//
        if(k==-1) return;
        //k의 개수만큼..
        for(int i=0;i<line.length();i++){
            if(i+k < line.length()) {
                set.add(line.substring(i, i+k+1));
            }
        }
        lineSplit(k-1, line);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        set = new HashSet<>();
        String line = s.next();//문자열
        lineSplit(line.length(), line);
        System.out.println(set.size());
    }
}