import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M, R;
	static List<List<Integer>> list = new ArrayList<>();
	static int[] visited;
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		visited = new int[N + 1]; 

		for (int i = 0 ; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			// 양방향 처리
			list.get(u).add(v);
			list.get(v).add(u);
		}
		
		for (int i = 1; i <= N; i++) {
			Collections.sort(list.get(i), Collections.reverseOrder());
		}
		
		bfs(R);
		
		for (int i = 1; i <= N; i++) {
			sb.append(visited[i]).append("\n");
		}
		
		br.close();
		System.out.println(sb);
		
	}
	
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		
		int count = 1; 
		
		q.offer(start);
		visited[start] = count++;
		
		while(!q.isEmpty()) {
			int v = q.poll();
			
			for (int i = 0; i < list.get(v).size(); i++) {
				int w = list.get(v).get(i);
				
				if(visited[w] != 0) continue;
				
				q.offer(w);
				visited[w] = count++;
			}
		}
	}

}
