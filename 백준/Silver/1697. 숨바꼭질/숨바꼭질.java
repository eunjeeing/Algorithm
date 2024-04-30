import java.io.*;
import java.util.*;

public class Main {
	
	static int[] dx = { -1, 1, 2 };
	static int N, K;
	static int[] chk = new int[100001];
	
	public static void main(String[] arg) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		if (N == K) {
			System.out.println(0);
		} else {
			bfs(N);
		}
	}
	
	static void bfs(int num) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(num);
		chk[num] = 1;
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			
			for (int i = 0; i < 3; i++) {
				int next;
				
				if(i == 2) {
					next = temp * dx[i];
				} else {
					next = temp + dx[i];
				}
				
				if(next == K) {
					System.out.println(chk[temp]);
					return;
				}
				
				if(next >= 0 && next < chk.length && chk[next] == 0) {
					q.offer(next);
					chk[next] = chk[temp] + 1;
				}
			}
		}
	}

}
