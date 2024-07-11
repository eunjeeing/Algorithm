import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String str : participant) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        
        for (String str : completion) {
            if(map.get(str) == 1) {
                map.remove(str);
            } else {
                map.replace(str, map.get(str)-1);
            }
        }
        
        String answer = map.keySet().iterator().next();
        return answer;
    }
}