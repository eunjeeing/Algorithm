import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M;
	static boolean[] check;
	static int[] arr, arr2;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		check = new boolean[N+1];
		arr = new int[N+1];
		arr2 = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i < N+1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		dfs(0);
		System.out.println(sb);

	}
	
	public static void dfs(int depth) {
		if(depth == M) {
			for (int i = 1; i <= depth; i++) {
				sb.append(arr2[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		int before = 0;
		for (int i = 1; i <= N; i++) {
			if(!check[i] && before != arr[i]) {
				check[i] = true;
				arr2[depth+1] = arr[i];
				before = arr[i];
				dfs(depth+1);
				check[i] = false;
			}

		}
		
		
	}

}
