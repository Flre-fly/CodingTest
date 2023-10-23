class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        long xx = x;
        long flag = x;
        for(int i=0;i<n;i++){
            answer[i] = xx;
            xx += flag;
        }
        return answer;
    }
}