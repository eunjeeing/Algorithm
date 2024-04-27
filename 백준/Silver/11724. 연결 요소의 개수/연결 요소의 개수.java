import java.util.*;
import java.io.*;

public class Main {
	static int N, M, count;
	static boolean[] visited;
	static int[][] node;
	
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			for (int i = 1; i <= N; i++) {
				if(node[temp][i] == 1 && !visited[i]) {
					q.offer(i);
					visited[i] = true;
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		node = new int[N+1][N+1];
		visited = new boolean[N+1];
				
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			node[u][v] = node[v][u] = 1;
		}
		
		for(int i = 1; i <= N; i++) {
			if(!visited[i]) {
				bfs(i);
				count++;
			}
		}
		System.out.println(count);
	}

}
