import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static char[][] map;
	static boolean[][] visited;
	static int count;
	static int startX, startY;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if(str.charAt(j) == 'I') {
					startX = i;
					startY = j;
				}
			}
		}
		
		bfs(startX, startY);
		System.out.println(count == 0 ? "TT" : count);
		
	}
	
	public static void bfs(int x, int y) {
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
				
				if(nextX >= 0 && nextY >= 0 && nextX < N && nextY < M) {
					if(!visited[nextX][nextY] && map[nextX][nextY] != 'X') {
						if(map[nextX][nextY] == 'P') count++;
						q.offer(new int[] {nextX, nextY});
						visited[nextX][nextY] = true;
					}

				}

			}
		}
	}

}
