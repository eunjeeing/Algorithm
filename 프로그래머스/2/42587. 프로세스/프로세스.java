import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<int[]> q = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < priorities.length; i++) {
            q.offer(new int[] {i, priorities[i]});
        }
        
        Arrays.sort(priorities);
        for (int i = 0; i < priorities.length; i++) {
            stack.push(priorities[i]);
        }
        
        int time = 0;
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            if (temp[1] != stack.peek()) {
                q.offer(new int[] {temp[0], temp[1]});
            } else {
                stack.pop();
                time++;
            }
            
            if (temp[0] == location) answer = time;
        }
                
        return answer;
    }
}