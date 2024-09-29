import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        int len = genres.length;
        
        // 장르 개수
        HashMap<String, Integer> map = new HashMap<>();
        
        // 재생 횟수
        HashMap<String, HashMap<Integer, Integer>> map2 = new HashMap<>();
        
        for (int i = 0; i < len; i++) {
            if (!map.containsKey(genres[i])) {
                HashMap<Integer, Integer> map3 = new HashMap<>();
                map3.put(i, plays[i]);
                map.put(genres[i], plays[i]);
                map2.put(genres[i], map3);
            } else {
                map2.get(genres[i]).put(i, plays[i]);
                map.put(genres[i], map.get(genres[i]) + plays[i]);
            }
        }
        
        
        List<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));
        
        for (String key : keySet) {
            HashMap<Integer, Integer> map4 = map2.get(key);
            List<Integer> genre = new ArrayList<>(map4.keySet());
            
            genre.sort((o1, o2) -> map4.get(o2).compareTo(map4.get(o1)));
            
            answer.add(genre.get(0));
            if (genre.size() > 1) {
                answer.add(genre.get(1));
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}