class Solution {
    public int[] solution(String[] wallpaper) {
        int minR=wallpaper.length;
        int minC=wallpaper[0].length();
        int maxR=0;
        int maxC=0;
        for(int i=0;i<wallpaper.length;i++){
            char arr[] = wallpaper[i].toCharArray();
            for(int j=0;j<arr.length;j++){
                if(arr[j]=='#'){
                    minR = Math.min(minR, i);
                    minC = Math.min(minC, j);
                    maxR = Math.max(maxR, i+1);
                    maxC = Math.max(maxC, j+1);
                }
            }
        }
        int[] answer = {minR, minC, maxR, maxC};
        return answer;
    }
}