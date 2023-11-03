class Solution {
    int [][] location = {
            {3,1},//0
            {0,0},//1
            {0,1},//2
            {0,2},//3
            {1,0},//4
            {1,1},//5
            {1,2},//6
            {2,0},//7
            {2,1},//8
            {2,2}//9
        };
    boolean isLeftHand = true;
    boolean isLeftBigger(int[] left, int[] right, int ciriteria){
        int ld = Math.abs(location[ciriteria][0] - left[0]) 
                    + Math.abs(location[ciriteria][1] - left[1]);
        int rd = Math.abs(location[ciriteria][0] - right[0]) 
                    + Math.abs(location[ciriteria][1] - right[1]);
        if(ld==rd){
            if(isLeftHand) return false;
            else return true;
        } 
        return (ld-rd)>0;
    }
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        isLeftHand = hand.equals("left")?true:false;
        int []left = {3,0};
        int []right = {3,2};
        
        for(int number: numbers){
            if(number %3==1){
                sb.append("L");
                left[0] = location[number][0];
                left[1] = location[number][1];
            }else if(number ==3 ||number ==6||number ==9 ){
                sb.append("R");
                right[0] = location[number][0];
                right[1] = location[number][1];
            }else{
                if(isLeftBigger(left, right, number)) {
                    sb.append("R");
                    right[0] = location[number][0];
                    right[1] = location[number][1];
                }else{
                    sb.append("L");
                    left[0] = location[number][0];
                    left[1] = location[number][1];
                }
            }
        }
        
        return sb.toString();
    }
}