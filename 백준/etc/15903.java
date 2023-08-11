//1446

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();//카드 개수
        int m = s.nextInt();//카드 합체를 몇번 하는지
        PriorityQueue<Long> q = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            q.add((long) s.nextInt());
        }
        for(int i =0;i<m;i++){
            long a =q.poll();
            long b = q.poll();
            long c = a+b;
            q.add(c);
            q.add(c);
        }
        long sum = 0;
        for(int i=0;!q.isEmpty();i++){
            sum += q.poll();
        }
        System.out.println(sum);

    }
}
