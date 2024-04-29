import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, R, count;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static int[] check;
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		check = new int[N+1];

		
		for (int i = 0; i < N+1; i++) {
			graph.add(new ArrayList<>());
		}
				
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph.get(u).add(v);
			graph.get(v).add(u);
			
		}
		
		br.close();
		
		for (int i = 1; i < graph.size(); i++) {
			Collections.sort(graph.get(i));
		}
		
		count = 1;
		dfs(R);
		
		for(int i = 1; i < check.length; i++) {
			sb.append(check[i]).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	static void dfs(int x) {		
		check[x] = count;
		
		for (int i = 0; i < graph.get(x).size(); i++) {
			int newX = graph.get(x).get(i);
			
			if(check[newX] == 0) {
				count++;
				dfs(newX);
			}
		}
		
	}

}
