class Solution {
    public int[] solution(long n) {
        String str = String.valueOf(n);
        int[] answer = new int[str.length()];
        for(int i=0;i<answer.length;i++){
            answer[i] = (int)(n%10);
            if(n<10) break;
            n/=10;
        }
        
        return answer;
    }
}