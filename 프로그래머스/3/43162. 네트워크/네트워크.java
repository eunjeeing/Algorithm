import java.util.*;

class Solution {
    
    static boolean[] visited;
    static int count = 0;
    
    public int solution(int n, int[][] computers) {
        
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            bfs(n, computers, i);
        }
                
        System.out.println(count);
        
        int answer = n - count;
        return answer;
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
                    count++;
                }
            }
        }
    }
}