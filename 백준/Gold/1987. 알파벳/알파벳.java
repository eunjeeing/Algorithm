import java.util.*;
import java.io.*;

public class Main {

    static int R, C;
    static char[][] board;
    static boolean[] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        visited = new boolean[26];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        visited[board[0][0] - 'A'] = true;
        dfs(0, 0, 1);
        System.out.println(max);

    }

    public static void dfs(int x, int y, int count) {
        max = Math.max(max, count);

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX >= 0 && nextX < R && nextY >= 0 && nextY < C) {
                char nextAlphabet = board[nextX][nextY];
                if (!visited[nextAlphabet - 'A']) {
                    visited[nextAlphabet - 'A'] = true;
                    dfs(nextX, nextY, count + 1);
                    visited[nextAlphabet - 'A'] = false;
                }
            }
        }
    }
}