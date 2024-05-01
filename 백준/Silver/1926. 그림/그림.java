import java.util.*;
import java.io.*;

public class Main {
	
	static int n, m, count;
	static int[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean[][] visited;
	static List<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // 세로 
		m = Integer.parseInt(st.nextToken()); // 가로 
		
		map = new int[n][m];
		visited = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
			}
		}
		for (int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					bfs(i, j);
					list.add(count);
				}
			}
		}
		br.close();
		
		Collections.sort(list);
		sb.append(list.size()).append("\n");
		if(list.size() != 0 ) sb.append(list.get(list.size()-1));
		else sb.append("0");
		
		System.out.println(sb);

	}
	
	static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		visited[x][y] = true;
		count = 0;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int nowX = now[0];
			int nowY = now[1];
			count++;
			
			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
				if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
					if(!visited[nextX][nextY] && map[nextX][nextY] == 1) {
						q.offer(new int[] {nextX, nextY});
						visited[nextX][nextY] = true;
					}
				}
			}
		}
	}
	
	
}
