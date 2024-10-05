import java.util.*;
import java.io.*;

public class Main {

    static int N, M, H;
    static int[][][] map;
    static int dx[] = {-1, 1, 0, 0, 0, 0};
    static int dy[] = {0, 0, 1, -1, 0, 0};
    static int dz[] = {0, 0, 0, 0, 1, -1};
    static Queue<Point> tomato = new LinkedList<>();

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if (map[i][j][k] == 1) {
                        tomato.offer(new Point(i, j, k));
                    }
                }
            }
        }

        int result = bfs();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(map[i][j][k] == 0) {
                        result = -1;
                    }
                }
            }
        }
        System.out.println(result);
    }

    static int bfs() {
        int count = 0;

        while (!tomato.isEmpty()) {
            Point c = tomato.poll();
            for (int i = 0; i < 6; i++) {
                int nx = c.x + dx[i];
                int ny = c.y + dy[i];
                int nz = c.z + dz[i];

                if (nx >= 0 && nx < H && ny >= 0 && ny < N && nz >= 0 && nz < M) {
                    if (map[nx][ny][nz] == 0) {
                        tomato.offer(new Point(nx, ny, nz));
                        map[nx][ny][nz] = map[c.x][c.y][c.z] + 1;
                    }
                }
            }
        }
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    count = Math.max(count, map[i][j][k]);
                }
            }
        }
        return count-1;
    }

    static class Point {
        int x, y, z;

        Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}