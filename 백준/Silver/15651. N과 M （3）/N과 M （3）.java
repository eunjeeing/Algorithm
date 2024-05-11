import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static boolean[] check;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		check = new boolean[N+1];
		arr = new int[N+1];
		for(int i = 1; i < N+1; i++) {
			arr[i] = i;
		}
		
		backTracking(0);
		System.out.println(sb);

	}
	
	static void backTracking (int K) {
		if (K == M) {
			for (int i = 1; i < K + 1; i++) {
				sb.append(arr[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 1; i < N + 1; i++) {

				arr[K+1] = i;
				backTracking(K+1);
			
		}
	}
	
}
