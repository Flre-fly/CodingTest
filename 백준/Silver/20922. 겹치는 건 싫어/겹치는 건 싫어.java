import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] sequence = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        int[] count = new int[100001];
        int left = 0, right = 0, maxLength = 0;

        while (right < N) {
            count[sequence[right]]++;
            while (count[sequence[right]] > K) {
                count[sequence[left]]--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        System.out.println(maxLength);
    }
}