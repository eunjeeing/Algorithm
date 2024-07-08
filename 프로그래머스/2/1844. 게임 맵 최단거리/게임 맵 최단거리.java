import java.util.*;
import java.io.*;

class Solution {
    
    static boolean[][] visited;
    static int n, m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {

        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        
        // List<Integer> list = new ArrayList<>();
        // int result = bfs(maps, 0, 0);
        // list.add(result);
            
        // Collections.sort(list);
        
        int answer = bfs(maps, 0, 0);
        return answer;
    }
    
    public static int bfs(int[][] maps, int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.offer(new int[] {x, y});
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];
            
            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                
                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
                    if (!visited[nextX][nextY] && maps[nextX][nextY] == 1) {
                        q.offer(new int[] {nextX, nextY});
                        visited[nextX][nextY] = true;
                        maps[nextX][nextY] = maps[nowX][nowY] + 1;
                    }
                }
            }
        }
        return maps[n - 1][m - 1] > 1 ? maps[n - 1][m - 1] : -1;
    }
}