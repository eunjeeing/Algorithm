import java.util.*;
import java.io.*;

public class Main {

    static int N, K;
    static int[] dx = {-1, 1, 2};
    static int[] check = new int[100001];

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(bfs(N));
    }

    static int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {
            int current = q.poll();

            if (current == K) {
                return check[current];
            }

            for (int i = 0; i < 3; i++) {
                int next;
                if (i == 2) {
                    next = current * dx[i];
                } else {
                    next = current + dx[i];
                }

                if (next >= 0 && next < 100001) {
                    if (check[next] == 0) {
                        check[next] = check[current]+1;
                        q.offer(next);
                    }
                }
            }
        }
        return 0;
    }
}