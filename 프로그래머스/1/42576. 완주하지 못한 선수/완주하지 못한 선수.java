import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> partiMap = new HashMap<>();
        for(String p : participant){
            partiMap.put(p, partiMap.getOrDefault(p, 0) + 1);
        }
        for(String c : completion){
            if(partiMap.containsKey(c)){
                if(partiMap.get(c) == 1 ) {
                    partiMap.remove(c);
                } else {
                    partiMap.put(c, partiMap.get(c) - 1);
                }
            }
        }
        String answer = "";
        for(String p : partiMap.keySet()){
            answer = p;
        }
        return answer;
    }
}