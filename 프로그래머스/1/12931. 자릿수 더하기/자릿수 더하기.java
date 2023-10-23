import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        String str = n+"";
        int len = str.length();
        char c[] = str.toCharArray();
        for(int i=0;i<c.length;i++){
            answer += c[i] - '0';
        }

        return answer;
    }
}