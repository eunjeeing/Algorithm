import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int result = bfs(0, 0);
        System.out.println(result);
    }

    public static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y, 0, 1});
        visited[x][y][0] = true;

        while(!q.isEmpty()) {
            int now[] = q.poll();
            int nowX = now[0];
            int nowY = now[1];
            int broken = now[2];
            int distance = now[3];

            if (nowX == N-1 && nowY == M-1) {
                return distance;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY <M) {
                    // 벽을 부수지 않은 경우
                    if (broken == 0) {
                        if (map[nextX][nextY] == 1) {
                            // 벽 부수기
                            q.offer(new int[] {nextX, nextY, 1, distance + 1});
                            visited[nextX][nextY][1] = true;
                        } else if (!visited[nextX][nextY][0]) {
                            // 이동하기
                            q.offer(new int[] {nextX, nextY, 0, distance + 1});
                            visited[nextX][nextY][0] = true;
                        }
                    } else {
                        if (!visited[nextX][nextY][broken] && map[nextX][nextY] == 0) {
                            q.offer(new int[] {nextX, nextY, broken, distance + 1});
                            visited[nextX][nextY][broken] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }
}
