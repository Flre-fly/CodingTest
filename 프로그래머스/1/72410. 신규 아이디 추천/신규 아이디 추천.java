class Solution {
    public String solution(String new_id) {
        new_id = toLower(new_id);
        new_id = removeChar(new_id);
        new_id = dotsToDot(new_id);
        new_id = removeDotsAtStartOrEnd(new_id);
        new_id = addA(new_id);
        new_id = only15Length(new_id);
        new_id = addLast(new_id);
        
        return new_id;
    }
    String toLower(String id){
        return id.toLowerCase();
    }
    String removeChar(String id){
         return id.replaceAll("[^a-z0-9\\._-]", "");
    }
    String dotsToDot(String id){
        return id.replaceAll("\\.{2,}", ".");
    }
    String removeDotsAtStartOrEnd(String input) {
        input = input.replaceAll("^\\.", "");
        return input.replaceAll("\\.$", "");
    }
    String addA(String id){
        if(id.isEmpty()){
            return "a";
        }
        return id;
    }
    String only15Length(String input){
        if (input.length() >= 16) {
            input = input.substring(0, 15);
        }
        if (input.endsWith(".")) {
            input = input.substring(0, input.length() - 1);
        }
        return input;
    }
    String addLast(String id){
        if(id.length()<=2){
            while(id.length()<3){
                id+=id.charAt(id.length() - 1);
            }
        }
        return id;
    }
}