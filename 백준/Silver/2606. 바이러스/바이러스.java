import java.io.*;
import java.util.*;

public class Main {
	
	public static int[][] node;
	public static boolean[] visited;
	public static int M,N;
	public static int result = 0;
	
	public static int dfs(int start) {
		
		visited[start] = true;
		
		for(int i = 1; i <= M; i++) {
			if(node[start][i] == 1 && !visited[i]) {
				dfs(i);
				result++;
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
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			node[m][n] = node[n][m] = 1;
		}
		
		System.out.println(dfs(1));
	}

}
