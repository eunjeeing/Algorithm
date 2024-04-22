import java.io.*;
import java.util.*;

public class Main {
	
	public static int[][] node;
	public static boolean[] visited;
	public static int M,N;
	public static int result = 0;
	
	public static int bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			
			for(int i = 1; i <= M; i++) {				
				if(node[temp][i] == 1 && !visited[i]) {
					visited[i] = true;
					q.offer(i);
					result++;
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		M = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());
		node = new int[M+1][M+1];
		visited = new boolean[M+1];
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			node[m][n] = node[n][m] = 1;
		}
		
		System.out.println(bfs(1));
	}

}
