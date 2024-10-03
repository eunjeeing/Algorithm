import java.util.*;
import java.io.*;

public class Main {

    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        visited = new boolean[n+1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        System.out.println(bfs(1));
    }

    static int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        int count = 0;

        while(!q.isEmpty()) {
            int current = q.poll();

            for (int i : graph.get(current)) {
                if(!visited[i]) {
                    visited[i] = true;
                    q.offer(i);
                    count++;
                }
            }
        }
        return count;
    }
}
