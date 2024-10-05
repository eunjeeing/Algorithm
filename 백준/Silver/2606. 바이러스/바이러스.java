import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int count = 0;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        visited = new boolean[N+1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

//        dfs(1);
//        System.out.println(count-1);

        bfs(1);
        System.out.println(count);
    }

    static void dfs(int start) {
        if (visited[start]) return;
        visited[start] = true;
        count++;

        for (int i : graph.get(start)) {
            if(!visited[i]) dfs(i);
        }
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int t = q.poll();
            for (int i : graph.get(t)) {
                if (!visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                    count++;
                }
            }
        }
    }
}