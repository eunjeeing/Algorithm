import java.util.*;

class Solution {
    
    static int len;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        len = rectangle.length;
        
        map = new int[101][101];
        visited = new boolean[101][101];
        
        for (int i = 0; i < len; i++) {
            int x1 = rectangle[i][0] * 2;
            int y1 = rectangle[i][1] * 2;
            int x2 = rectangle[i][2] * 2;
            int y2 = rectangle[i][3] * 2;

            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    if (x == x1 || x == x2 || y == y1 || y == y2) {
                        if (map[x][y] == 0) map[x][y] = 1;  // 경계선
                    } else {
                        map[x][y] = -1;  // 내부
                    }
                }
            }
        }
        
        Point character = new Point(characterX * 2, characterY * 2);
        Point item = new Point(itemX * 2, itemY * 2);
        
        int answer = bfs(character, item);

        return answer;
    }
    
    static int bfs(Point character, Point item){
        Queue<Point> q = new LinkedList<>();
        q.offer(character);
        visited[character.x][character.y] = true;
        
        while(!q.isEmpty()) {
            Point current = q.poll();
            
            if (current.x == item.x && current.y == item.y) {
                return map[current.x][current.y] / 2;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                
                if (nx >= 0 && nx < 101 && ny >= 0 && ny < 101) {
                    if (!visited[nx][ny] && map[nx][ny] == 1) {
                        q.offer(new Point(nx, ny));
                        visited[nx][ny] = true;
                        map[nx][ny] = map[current.x][current.y] + 1;
                    }
                }
            }
        }
        return -1;
    }
    
    static class Point {
        int x, y;
        
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}