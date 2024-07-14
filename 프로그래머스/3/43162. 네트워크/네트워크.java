import java.util.*;

class Solution {
    
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        
        visited = new boolean[n];
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            if(!visited[i]) {
                bfs(n, computers, i);
               count++;
            }
        }
           
        return count;
    }
    
    public void bfs(int n, int[][] computers, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        
        while(!q.isEmpty()) {
            int temp = q.poll();
            for (int i = 0; i < n; i++) {
                if (computers[temp][i] == 1 && !visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
