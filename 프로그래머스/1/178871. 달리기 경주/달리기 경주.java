import java.util.*;
class Solution {
    Map<String, Integer> map;
    void swap(int index, String[] players){
        String temp = players[index];
        players[index] = players[index-1];
        players[index-1] = temp;
        
        map.put(players[index], index);
        map.put(players[index-1], index-1);
    }
    public String[] solution(String[] players, String[] callings) {
        map = new HashMap<>();
        for(int i=0;i<players.length;i++){
            map.put(players[i], i);
        }
        for(int i=0;i<callings.length;i++){
            Integer index = map.get(callings[i]);
            swap(index, players);
        }
        return players;
    }
}