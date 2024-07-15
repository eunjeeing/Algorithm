import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int cnt = 0;
    static int[] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N];

        dfs(0);
        System.out.println(cnt);
    }

    public static void dfs (int row) {
        if (row == N) {
            cnt++;
            return;
        }

        for (int col = 0; col < N; col++) {
            board[row] = col;

            boolean check = true;
            for (int i = 0; i < row; i++) {
                if (board[i] == board[row] || Math.abs(board[row] - board[i]) == Math.abs(row - i)) {
                    check = false;
                    break;
                }
            }
            if (check) {
                dfs(row+1);
            }
        }
    }
}
