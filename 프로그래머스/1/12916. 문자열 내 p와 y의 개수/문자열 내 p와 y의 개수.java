class Solution {
    boolean solution(String s) {
        boolean answer = true;

        s = s.toUpperCase();
        int[] count = new int[2];
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'P') count[0]++;
            else if(s.charAt(i) == 'Y') count[1]++;
        }
        
        answer = count[0] == count[1] ? true : false;

        return answer;
    }
}