import java.util.*;
import java.io.*;

class Solution {
    
    static int n, m;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        n = maps.length;
        m = maps[0].length;
        
        visited = new boolean[n][m];
        
        return bfs(maps, new Point(0, 0));
    }
    
    static int bfs(int[][] maps, Point start) {
        Queue<Point> q = new LinkedList<>();
        q.offer(start);
        visited[start.x][start.y] = true;
        
        while(!q.isEmpty()) {
            Point current = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (maps[nx][ny] == 1 && !visited[nx][ny]) {
                        q.offer(new Point(nx, ny));
                        visited[nx][ny] = true;
                        maps[nx][ny] = maps[current.x][current.y] + 1;
                    }
                }
            }
        }
        return maps[n-1][m-1] > 1 ? maps[n-1][m-1] : -1;
    }
    
    static class Point {
        int x, y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}