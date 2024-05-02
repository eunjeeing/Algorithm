import java.util.*;
import java.io.*;

public class Main {
	
	static int M, N, K;
	static boolean[][] visited;
	static int[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int count = 0;
	static List<Integer> areaList = new ArrayList<>();
	
	public static void main(String[] arg) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		visited = new boolean[M][N];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int leftX = Integer.parseInt(st.nextToken());
			int leftY = Integer.parseInt(st.nextToken());
			int rightX = Integer.parseInt(st.nextToken());
			int rightY = Integer.parseInt(st.nextToken());
			
			for (int j = leftY; j < rightY; j++) {
				for (int k = leftX; k < rightX; k++) {
					map[j][k] = 1;
				}
			}
		}
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j] && map[i][j] == 0) {
					bfs(i, j);
					count++;
				}
			}
		}
		sb.append(count).append("\n");
		
		Collections.sort(areaList);
		for (int i : areaList) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);
		
	}
	
	public static void bfs(int x, int y) {
		int area = 1;
		
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
				if(nextX >= 0 && nextX < M && nextY >=0 && nextY < N) {
					if(!visited[nextX][nextY] && map[nextX][nextY] == 0) {
						q.offer(new int[] {nextX, nextY});
						visited[nextX][nextY] = true;
						area++;
					}
				}
			}
		}
		areaList.add(area);
	}
	
	

}
