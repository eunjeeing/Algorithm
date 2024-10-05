import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static int a, b;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int result = -1;

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        dfs(a, 0);
        // bfs(a);
        System.out.println(result);
    }

    static void dfs(int start, int count) {
        if (start == b) {
            result = count;
            return;
        }
        visited[start] = true;

        for (int i : graph.get(start)) {
            if(!visited[i]) {
                dfs(i, count+1);
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        int count = 0;

        while(!q.isEmpty()) {
            int t = q.poll();

            if (t == b) {
                result = count;
                return;
            }

            for (int i : graph.get(t)) {
                if(!visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                    count++;
                }
            }
        }
    }
}