class Solution {
    boolean solution(String s) {
        char[] arr = s.toCharArray();
        int pCount = counting(arr, 'p');
        int yCount = counting(arr, 'y');
        if(pCount==0 && yCount==0) return true;
        return pCount==yCount;
    }
    int counting(char[] arr, char x){
        int count = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==x || arr[i]==(char)(x-32)) count++;
        }
        return count;
    }
}