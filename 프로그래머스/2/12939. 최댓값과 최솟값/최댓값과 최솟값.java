import java.io.*;
import java.util.*;

class Solution {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s);
        List<Integer> list = new ArrayList<>();
        
        while(st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        
        Collections.sort(list);
        int min = list.get(0);
        int max = list.get(list.size()-1);
        String answer = min + " " + max;
        
        return answer;
    }
}