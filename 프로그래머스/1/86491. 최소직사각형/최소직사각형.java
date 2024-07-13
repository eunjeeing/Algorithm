import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        
        for (int[] arr : sizes) {
            Arrays.sort(arr);
        }
        
        int w = -1;
        int h = -1;

        for (int i = 0; i < sizes.length; i++) {
            w = Math.max(sizes[i][0], w);
            h = Math.max(sizes[i][1], h);
        }
        
        return w*h;
    }
}