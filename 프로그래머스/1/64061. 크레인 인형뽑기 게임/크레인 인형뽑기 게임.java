import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        List<Stack<Integer>> stackList = new ArrayList<>();
        Stack<Integer> pocket = new Stack<>();
        int answer = 0;
        for(int i=0;i<board.length;i++){
            stackList.add(new Stack<>());
            for(int j=board[0].length-1;j>=0;j--){
                if(board[j][i] != 0) stackList.get(i).push(board[j][i]);
            }
        }
        for(int i: moves){
           
            if(stackList.get(i-1).isEmpty()){
                continue;
            }
            int item = stackList.get(i-1).pop();
            pocket.add(item);
            if(pocket.size()>=2 && 
               pocket.get(pocket.size()-1) == pocket.get(pocket.size()-2)){
                answer+=2;
                pocket.pop();
                pocket.pop();
            }
        }
    
        return answer;
    }
}