import java.util.*;
import java.io.*;

public class Main {

    static int L, R, C;
    static char[][][] building;
    static boolean[][][] visited;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static int startX, startY, startZ = 0;
    static int endX, endY, endZ = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while(true) {
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            building = new char[L][R][C];
            visited = new boolean[L][R][C];

            if (L == 0 && R == 0 && C == 0) {
                break;
            }

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String line = br.readLine();
                    for (int k = 0; k < C; k++) {
                        building[i][j][k] = line.charAt(k);
                        if (building[i][j][k] == 'S') {
                            startX = k;
                            startY = j;
                            startZ = i;
                        } else if (building[i][j][k] == 'E') {
                            endX = k;
                            endY = j;
                            endZ = i;
                        }
                    }
                }
                br.readLine();
            }

            int res = bfs(startX, startY, startZ);
            if (res == -1) {
                sb.append("Trapped!").append("\n");
            } else {
                sb.append("Escaped in " + res + " minute(s).").append("\n");
            }
        }
        System.out.println(sb);

    }

    public static int bfs(int x, int y, int z) {
        Queue<int[]> q = new LinkedList<>();
        visited[z][y][x] = true;
        q.offer(new int[] {x, y, z, 0});

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];
            int nowZ = now[2];
            int time = now[3];

            if (nowX == endX && nowY == endY && nowZ == endZ) {
                return time;
            }

            for (int i = 0; i < 6; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                int nextZ = nowZ + dz[i];

                if (nextX >= 0 && nextX < C && nextY >= 0 && nextY < R && nextZ >= 0 && nextZ < L) {
                    if (!visited[nextZ][nextY][nextX] && building[nextZ][nextY][nextX] != '#') {
                        visited[nextZ][nextY][nextX] = true;
                        q.offer(new int[] {nextX, nextY, nextZ, time+1});
                    }
                }
            }
        }
        return -1;
    }
}
