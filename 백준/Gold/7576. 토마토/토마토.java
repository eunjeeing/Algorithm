import java.util.*;
import java.io.*;

public class Main {
	
	static int M, N;
	static int[][] box;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int count = 0;
	static Queue<int[]> q = new LinkedList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); // 가로 
		N = Integer.parseInt(st.nextToken()); // 세로 
		
		box = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int num = Integer.parseInt(st.nextToken());
				box[i][j] = num;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(box[i][j] == 1) {
					q.offer(new int[] { i, j });
				}
			}
		}
		System.out.print(bfs());
		
	}
	
	public static int bfs() {
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int nowX = now[0];
			int nowY = now[1];
			
			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
					if(box[nextX][nextY] == 0) {
						box[nextX][nextY] = box[nowX][nowY] + 1;
						q.offer(new int[] { nextX, nextY });
					}
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(box[i][j] == 0) {
					return -1;
				}
				count = Math.max(count, box[i][j]);
			}
		}
		if (count == 1) {
			return 0;
		} else {
			return count-1;
		}
	}


}
