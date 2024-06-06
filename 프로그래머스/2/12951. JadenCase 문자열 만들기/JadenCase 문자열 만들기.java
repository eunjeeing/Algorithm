import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        s = s.toLowerCase();
        StringTokenizer st = new StringTokenizer(s, " ", true);
        while(st.hasMoreTokens()) {
            String str = st.nextToken();
            if (str.equals(" ")) {
                answer += str;
            } else {
                answer += str.substring(0, 1).toUpperCase() + str.substring(1);
            }
        }

        return answer;
    }
}