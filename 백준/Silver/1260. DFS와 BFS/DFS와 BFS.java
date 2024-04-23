import java.util.*;
import java.io.*;

public class Main {
	
	public static StringBuilder sb = new StringBuilder();
	public static Queue<Integer> q = new LinkedList<>();
	public static int N, M, V;
	public static boolean[] visited;
	public static int[][] node;
	
	public static void bfs(int start) {
		q.offer(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			sb.append(temp).append(" ");
			for(int i = 1; i <= N; i++) {				
				if(node[temp][i] == 1 && !visited[i]) {
					visited[i] = true;
					q.offer(i);
				}
			}
		}
		
	}
	
	public static void dfs(int start) {
		visited[start] = true;
		sb.append(start).append(" ");
		
		for (int i = 1; i <= N; i++) {
			if(node[start][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		node = new int[N+1][N+1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			node[a][b] = node[b][a] = 1;
		}
		visited = new boolean[N+1];
		dfs(V);
		sb.append("\n");
		
		visited = new boolean[N+1];
		bfs(V);
		
		System.out.println(sb);
		
	}

}
