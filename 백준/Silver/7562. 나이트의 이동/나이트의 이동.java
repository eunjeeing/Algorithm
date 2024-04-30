import java.util.*;
import java.io.*;

public class Main {
	
	static int I, x1, y1, x2, y2;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] dy = { -2, -1, 1, 2, 2, 1, -1, -2 };
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			I = Integer.parseInt(br.readLine());
			map = new int[I][I];
			visited = new boolean[I][I];
			
			// 나이트의 현재 위치 
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			
			// 나이트가 이동하려고 하는 위치
			st = new StringTokenizer(br.readLine());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			
			bfs(x1, y1);
			sb.append(map[x2][y2]).append("\n");
		}
		System.out.println(sb);
	}
	
	static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int nowX = now[0];
			int nowY = now[1];
			
			if(nowX == x2 && nowY == y2) {
				return;
			}
			
			for (int i = 0 ; i < 8; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
				if(nextX >= 0 && nextY >= 0 && nextX < I && nextY < I) {
					if(!visited[nextX][nextY]) {
						q.offer(new int[] {nextX, nextY});
						map[nextX][nextY] = map[nowX][nowY]+1;
						visited[nextX][nextY] = true;
					}
				}
			}
		}
	}
	
}
