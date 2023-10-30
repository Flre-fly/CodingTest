import java.util.*;
class Solution {
    int addDate(int day, int addMonth){
        return addMonth * 28 + day;
    }
    int getDate(String date){
        String dateArr[] = date.split("\\.");
        int year = Integer.parseInt(dateArr[0]);
        int month = Integer.parseInt(dateArr[1]);
        int day = Integer.parseInt(dateArr[2]);
        return day + month*28 + year*12*28;
    }
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> map = new HashMap<>();
        for(String term: terms){
            String termArr[] = term.split(" ");
            map.put(termArr[0], Integer.parseInt(termArr[1]));
        }
        int originDate = getDate(today);
        List<Integer> answer = new ArrayList<>();
        for(int i=0;i<privacies.length;i++){
            String dateStr = privacies[i].split(" ")[0];
            String type = privacies[i].split(" ")[1];
            int tranDate = addDate(getDate(dateStr), map.get(type));
            System.out.println(tranDate + " " + originDate);
            if(tranDate <= originDate) answer.add(i+1);
        }
    
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}