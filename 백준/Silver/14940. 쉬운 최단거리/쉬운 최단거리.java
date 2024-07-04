import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int[][] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int [n][m];
        visited = new boolean[n][m];
        distance = new int[n][m];

        int startX = -1, startY = -1;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    startX = i;
                    startY = j;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], -1);
        }

        bfs(startX, startY);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 0) {
                    distance[i][j] = 0;
                }
                sb.append(distance[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});
        visited[x][y] = true;
        distance[x][y] = 0;

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
                    if(!visited[nextX][nextY] && map[nextX][nextY] == 1) {
                        visited[nextX][nextY] = true;
                        distance[nextX][nextY] = distance[nowX][nowY] + 1;
                        q.offer(new int[] {nextX, nextY});
                    }
                }
            }
        }
    }

}
