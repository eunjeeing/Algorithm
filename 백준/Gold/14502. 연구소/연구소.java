import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[][] lab;
	static List<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 세로 
		M = Integer.parseInt(st.nextToken()); // 가로
		lab = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				lab[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	
		dfs(0);
		Collections.sort(list);
		System.out.println(list.get(list.size()-1));
	}
		

	public static void dfs(int cnt) {
		if(cnt == 3) {
			bfs();
			return;
		} 
		
		for(int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(lab[i][j] == 0) {
					lab[i][j] = 1;
					dfs(cnt+1);
					lab[i][j] = 0;
				}
			}
		}
		
	}
	
	public static void bfs() {
		int count = 0;
		Queue<int[]> q = new LinkedList<>();
		int[][] lab2 = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				lab2[i][j] = lab[i][j];
				if(lab2[i][j] == 2) {
					q.offer(new int[] {i, j});
				}
			}
		}
		
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int nowX = now[0];
			int nowY = now[1];
			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
					if(lab2[nextX][nextY] == 0) {
						lab2[nextX][nextY] = 2;
						q.offer(new int[] { nextX, nextY });
					}
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(lab2[i][j] == 0) {
					count++;
				}
			}
		}
		list.add(count);
	}

}
