import java.io.*;
import java.util.*;

public class Main {
	
	static int M, N, K, count;
	static boolean[][] visited;
	static int[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[M][N];
			visited = new boolean[M][N];
			
			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				map[X][Y] = 1;
			}
			
			count = 0;

			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						bfs(i, j);
						count++;
					}
				}
			}
			System.out.println(count);
		}
		

		
	}
	
	static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int nowX = now[0];
			int nowY = now[1];
			
 			for (int i = 0; i < 4; i++) {
 				int nextX = nowX + dx[i];
 				int nextY = nowY + dy[i];
 				
 				if(nextX >= 0 && nextY >= 0 && nextX < M && nextY < N) {
 					if(!visited[nextX][nextY] && map[nextX][nextY] == 1) {
 	 					q.offer(new int[] {nextX, nextY});
 	 					visited[nextX][nextY] = true;
 					}

 				}
 			}
		
		}
	}
	
}
