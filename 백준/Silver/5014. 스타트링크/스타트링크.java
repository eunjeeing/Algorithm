import java.util.*;
import java.io.*;

public class Main {

    static int F, S, G, U, D;
    static int[] dx = new int[2];
    static int[] check;
    static int result = 0;

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        check = new int[F+1];

        dx[0] = U;
        dx[1] = D;

        bfs(S);
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        check[start] = 1;

        while(!q.isEmpty()) {
            int cur = q.poll();

            if (cur == G) {
                System.out.println(check[cur]-1);
                return;
            }

            for (int i = 0; i < 2; i++) {
                int nx;
                if (i == 0) {
                    nx = cur + dx[i];
                } else {
                    nx = cur - dx[i];
                }

                if (nx >= 1 && nx <= F && check[nx] == 0) {
                    q.offer(nx);
                    check[nx] = check[cur] + 1;
                }
            }
        }
        System.out.println("use the stairs");
    }
}