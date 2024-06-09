import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M;
	static List<List<Integer>> graph = new ArrayList<>();
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;
	static int ans = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		for (int i = 1; i <= N; i++) {
			visited = new boolean[N+1];
			bfs(i);
		}
		
		System.out.println(ans);
			
	}
	
	public static void bfs(int start) {
		int res = 0;
		Queue<int[]> q = new LinkedList<>();
		
		q.add(new int[] {start, 0});
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int idx = cur[0]; 
			int cnt = cur[1]; 
			
			for (int i = 0; i < graph.get(idx).size(); i++) {
				int w = graph.get(idx).get(i);
				
				if(!visited[w]) {
					res += cnt + 1;
					q.add(new int[] {w, cnt+1});
					visited[w] = true;
				}
			}
		}
		if(res < min) {
			min = res;
			ans = start;
		}
	}

}
