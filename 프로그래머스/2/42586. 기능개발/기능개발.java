import java.util.*;

class Solution {
    public List solution(int[] progresses, int[] speeds) {
        
        Queue<Integer> days = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            int count = 0;
            while(progresses[i] < 100) {
                progresses[i] += speeds[i];
                count++;
            }
            days.add(count);
        }
        
        List<Integer> deployCounts = new ArrayList<>();
        while(!days.isEmpty()) {
            int temp = days.poll();
            int count = 1;
            
            while(!days.isEmpty() && temp >= days.peek()) {
                count++;
                days.poll();
            }        
            System.out.println(count);
            deployCounts.add(count);
        }
        
        return deployCounts;
    }
}