import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] maze;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        maze = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0, 0));

    }

    public static int bfs(int x, int y) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        visited[x][y] = true;
        pq.offer(new int[] {x, y, 0});

        while(!pq.isEmpty()) {
            int[] now = pq.poll();
            int nowX = now[0];
            int nowY = now[1];
            int count = now[2];

            if (nowX == N-1 && nowY == M-1) {
                return count;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
                    if (!visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        if (maze[nextX][nextY] == 1) {
                            pq.offer(new int[] {nextX, nextY, count + 1});
                        } else {
                            pq.offer(new int[] {nextX, nextY, count});
                        }
                    }
                }
            }
        }
        return -1;
    }
}
