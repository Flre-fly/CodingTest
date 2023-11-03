import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
        int[] stack = new int[ingredient.length];
        int sc = 0;
        int answer = 0;
        for(int i: ingredient){
            stack[sc++] = i;
            if(sc >= 4 &&
               stack[sc-4]==1 && 
               stack[sc-3]==2 && 
               stack[sc-2]==3 && 
               stack[sc-1]==1){
                answer++;
                sc -= 4;//스택에서 4개 없앤 효과
            }
        }
        
        return answer;
    }
}