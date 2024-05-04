import java.util.*;
import java.io.*;

public class Main {
	
	static int n, m, num1, num2;
	static boolean[] visited;
	static List<List<Integer>> graph = new ArrayList<>();
	static int result = -1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine()); // 전체 사람 수 
		st = new StringTokenizer(br.readLine());
		
		num1 = Integer.parseInt(st.nextToken());
		num2 = Integer.parseInt(st.nextToken());
		
		m = Integer.parseInt(br.readLine());
		
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		visited = new boolean[n+1];
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			graph.get(x).add(y);
			graph.get(y).add(x);
		}
		
		dfs(num1, num2, 0);
		System.out.println(result);
	}
	
	public static void dfs(int start, int end, int count) {
		if(start == end) {
			result = count;
			return;
		}
		
		visited[start] = true;
		for (int i = 0; i < graph.get(start).size(); i++) {
			int w = graph.get(start).get(i);
			if(!visited[w]) {
				dfs(w, num2, count+1);
			}
		}
	}

}
