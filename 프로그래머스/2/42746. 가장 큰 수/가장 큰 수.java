import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        // 문자열 배열로 변환 
        String[] strArr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strArr[i] = String.valueOf(numbers[i]);
        }
        
        // 정렬 
        Arrays.sort(strArr, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        
        for (String str : strArr) {
            answer += str;
        }
        
        // 0인 경우 처리 
        if (answer.charAt(0) == '0') {
            answer = "0";
        }
        
        return answer;
    }
}