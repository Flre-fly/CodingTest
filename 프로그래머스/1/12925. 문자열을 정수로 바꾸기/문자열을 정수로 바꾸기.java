class Solution {
    public int solution(String s) {
        char[] arr = s.toCharArray();
        int answer = 0;
        int flag = 1;
        if(arr[0]=='-'){
            for(int i=arr.length-1;i>=1;i--){
                answer -= (arr[i]-'0') * flag;
                flag *= 10;
            }
        }else{
            if(arr[0]=='+'){
               for(int i=arr.length-1;i>=1;i--){
                answer += (arr[i]-'0') * flag;
                flag *= 10;
                } 
            }else{
                 for(int i=arr.length-1;i>=0;i--){
                    answer += (arr[i]-'0') * flag;
                    flag *= 10;
                } 
            }
             
        }
        return answer;
    }
}