import java.util.*;
import java.io.*;

public class Main {

    static int R, C;
    static char[][] map;
    static boolean[][] visited;
    static boolean[][] visited2;
    static int[][] fireTime;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];
        visited2 = new boolean[R][C];
        fireTime = new int[R][C];

        Queue<Point> fireQueue = new LinkedList<>();
        Point jihoonStart = null;

        // 입력
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
                fireTime[i][j] = -1;
            }
        }


        // 불
        int time = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'F') {
                    fireQueue.offer(new Point(i, j));
                    fireTime[i][j] = 0;
                } else if (map[i][j] == 'J') {
                    jihoonStart = new Point(i, j);
                }
            }
        }

        fire(fireQueue);
        int result = exit(jihoonStart);

        System.out.println(result == -1 ? "IMPOSSIBLE" : result);
    }

    static void fire(Queue<Point> fireQueue) {
        while(!fireQueue.isEmpty()) {
            Point now = fireQueue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                    if (map[nx][ny] != '#' && fireTime[nx][ny] == -1) {
                        fireQueue.offer(new Point(nx, ny));
                        fireTime[nx][ny] = fireTime[now.x][now.y] + 1;
                    }
                }
            }
        }
    }

    static int exit(Point start) {
        int time = 0;
        Queue<Point> q = new LinkedList<>();
        q.offer(start);
        visited2[start.x][start.y] = true;

        while(!q.isEmpty()) {
            int size = q.size();
            time++;

            for (int s = 0; s < size; s++) {
                Point now = q.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];
                    //                System.out.println(nx + " " + ny);

                    if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                        return time;
                    }

                    if (map[nx][ny] == '.' && !visited2[nx][ny]) {
                        if (fireTime[nx][ny] == -1 || fireTime[nx][ny] > time) {
                            q.offer(new Point(nx, ny));
                            visited2[nx][ny] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
