import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, K;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[][] aisle;
	static boolean[][] visited;
	static List<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 세로 
		M = Integer.parseInt(st.nextToken()); // 가로 
		K = Integer.parseInt(st.nextToken()); // 음식물 쓰레기 개수 
		aisle = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			aisle[row-1][col-1] = 1;
		}
		
		for(int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if(!visited[i-1][j-1] && aisle[i-1][j-1] == 1) {
					int count = bfs(i-1, j-1);
					list.add(count);
				}
			}
		}
		
		Collections.sort(list);
		System.out.println(list.get(list.size() - 1));
		
	}
	
	public static int bfs(int row, int col) {
		int count = 1;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {row, col});
		visited[row][col] = true;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int nowX = now[0];
			int nowY = now[1];
			
			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
				if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
					if(!visited[nextX][nextY] && aisle[nextX][nextY] == 1) {
						q.offer(new int[] {nextX, nextY});
						visited[nextX][nextY] = true;
						count++;
					}
				}
			}
			
		}
		return count;
	}

}
