import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean[][] visited;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int max = 1;
		map = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
			}
		}
		
		int result = 0;
		for(int i = 0; i <= max; i++) {
			visited = new boolean[N][N];
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if(map[j][k] > i && !visited[j][k]) {
						cnt++;
						bfs(j, k, i);
					}
				}
			}
			result = Math.max(result, cnt);
		}
		System.out.println(result);
		
	}
	
	public static void bfs(int x, int y, int height) {
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
				
				if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
					if(!visited[nextX][nextY] && map[nextX][nextY] > height) {
						q.offer(new int[] {nextX, nextY});
						visited[nextX][nextY] = true;
					}
				}
			}
		}
	}
	
}
