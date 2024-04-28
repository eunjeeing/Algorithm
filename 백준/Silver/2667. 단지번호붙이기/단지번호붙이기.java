import java.util.*;
import java.io.*;

public class Main {
	
	static int N, count;
	static boolean[][] visited;
	static int[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static List<Integer> list;
	static StringBuilder sb;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		list = new ArrayList<>();
		sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		
		for (int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					count = 0;
					bfs(i, j);
					list.add(count);
				}
			}
		}
		
		Collections.sort(list);
		sb.append(list.size()).append("\n");
		
		for(int i : list) {
			sb.append(i).append("\n");
		}
		System.out.println(sb);
		
	}
	
	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int nowX = now[0];
			int nowY = now[1];
			count++;
			
			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
				// map의 범위를 벗어난다면 
				if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
				if (visited[nextX][nextY] || map[nextX][nextY] == 0) continue;
				
				q.offer(new int[] {nextX, nextY});
				visited[nextX][nextY] = true;
			}
		}
	}

}
