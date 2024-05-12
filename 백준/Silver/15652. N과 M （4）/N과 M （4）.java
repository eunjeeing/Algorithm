import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1];
		for(int i = 1; i < N+1; i++) {
			arr[i] = i;
		}
		
		dfs(1, 0);
		System.out.println(sb);
	}
	
	public static void dfs(int at, int depth) {
		if(depth == M) {
			for (int i = 1; i <= depth; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = at; i <= N; i++) {
			arr[depth+1] = i;
			dfs(i, depth+1);
		}
		
		
	}

}
