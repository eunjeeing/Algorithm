import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        int removeZeroCount = 0;
        int convertCount = 0;
        while (!s.equals("1")) {
            int originLength = s.length();
            s = s.replace("0", "");
            int newLength = s.length();
            
            s = Integer.toBinaryString(newLength);
            removeZeroCount += originLength - newLength;
            convertCount++;
        }
        
        answer[0] = convertCount;
        answer[1] = removeZeroCount;
        
        return answer;
    }
}