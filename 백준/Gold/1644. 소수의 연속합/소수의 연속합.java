import java.io.*;
import java.util.*;

public class Main {
    static boolean prime[];
    static int n;
    static void primeGenerator() {
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if (prime[i]) {
                for(int k = i + i; k <= n; k += i) {
                    prime[k] = false;
                }
            }
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        prime = new boolean[n + 1];
        primeGenerator();
        int l = 0;
        int r = 0;
        int sum = 0;
        int result = 0;
        List<Integer> primeList = new ArrayList<>();
        for(int i = 2; i < prime.length; i++) {
            if (!prime[i]) continue; // Skip non-prime numbers
            primeList.add(i);
        }
        while(r < primeList.size() && primeList.get(r) <= n) {
            sum += primeList.get(r);
            r++;
            while(sum > n && l < r) {
                sum -= primeList.get(l);
                l++;
            }
            if(sum == n) result++;
        }
        System.out.println(result);
    }
}
