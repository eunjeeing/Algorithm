import java.util.*;
import java.io.*;

class Solution {
    
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if(!visited[i]) {
                bfs(n, computers, i);
                answer++;
            }
        }
        
        return answer;
    }
    
    static void bfs(int n, int[][] computers, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        
        while(!q.isEmpty()) {
            int now = q.poll();
            for (int i = 0; i < n; i++) {
                if (computers[now][i] == 1 && !visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}