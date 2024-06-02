import java.util.*;
import java.io.*;

public class Main {
	
	static int w, h;
	static char[][] maze;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int startX, startY;
	static Queue<int[]> fire;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			maze = new char[h][w];
			fire = new LinkedList<>();

			for (int i = 0; i < h; i++) {
				String str = br.readLine();
				for (int j = 0; j < w; j++) {
					maze[i][j] = str.charAt(j);
					if(maze[i][j] == '@') {
						startX = i;
						startY = j;
					}else if(maze[i][j] == '*') {
						fire.add(new int[] { i, j });
					}
				}
			}
			bfs(startX, startY);
		}
		System.out.println(sb);

	}

	public static void bfs(int x, int y) {
		int time = -1;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { -1, -1 });
		q.add(new int[] { x, y });
		visited = new boolean[h][w];
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int nowX = now[0];
			int nowY = now[1];

			if(nowX == -1 && nowY == -1) {
				burn();
				if(!q.isEmpty()) {
					q.add(now);
				}
				time++;
				continue;
 			}
			
			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];

				if(nextX >= h || nextY >= w || nextX < 0 || nextY < 0) {
					sb.append(time+1).append("\n");
					return;
				}

				if(!visited[nextX][nextY] && maze[nextX][nextY] == '.') {
						q.add(new int[] { nextX, nextY });
						visited[nextX][nextY] = true;
				}
			}
		}
		sb.append("IMPOSSIBLE").append("\n");
	}


	public static void burn() {
		int size = fire.size();

		for (int i = 0; i < size; i++) {
			int[] now = fire.poll();
			int nowX = now[0];
			int nowY = now[1];

			for (int j = 0; j < 4; j++) {
				int nextX = nowX + dx[j];
				int nextY = nowY + dy[j];

				if(nextX >= 0 && nextX < h && nextY >= 0 && nextY < w) {
					if(maze[nextX][nextY] == '.' || maze[nextX][nextY] == '@') {
						fire.add(new int[] { nextX, nextY });
						maze[nextX][nextY] = '*';
					}
				}
			}
		}
	}

}
