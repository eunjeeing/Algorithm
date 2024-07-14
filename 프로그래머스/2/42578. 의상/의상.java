import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        int count = 1;
        Collection<Integer> values = map.values();

        for (Integer value : values) {
            count *= (value+1);
        }
        
        return count-1;
    }
}