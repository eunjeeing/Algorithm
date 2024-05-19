import java.util.*;
import java.io.*;

public class Main {

	static int M, N, H;
	static int[][][] box;
	static int[] dx = { -1, 1, 0, 0, 0, 0 };
	static int[] dy = { 0, 0, -1, 1, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, -1, 1 };
	static Queue<int[]> q = new LinkedList<>();
	static int count = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); // 가로
		N = Integer.parseInt(st.nextToken()); // 세로
		H = Integer.parseInt(st.nextToken()); // 높이
		box = new int[H][N][M];

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) { 
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					box[i][j][k] = Integer.parseInt(st.nextToken());
					if (box[i][j][k] == 1) {
						q.offer(new int[] { i, j, k });
					}
				}
			}
		}

		System.out.println(bfs());

	}

	public static int bfs() {
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int nowZ = now[0];
			int nowX = now[1];
			int nowY = now[2];

			for (int i = 0; i < 6; i++) {
				int nextZ = nowZ + dz[i];
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];

				if (nextX >= 0 && nextY >= 0 && nextZ >= 0 && nextX < N && nextY < M && nextZ < H) {
					if (box[nextZ][nextX][nextY] == 0) {
						box[nextZ][nextX][nextY] = box[nowZ][nowX][nowY] + 1;
						q.offer(new int[] { nextZ, nextX, nextY });
					}
				}
			}
		}
		for (int i = 0; i < H; i++) {	
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if(box[i][j][k] == 0) {
						return -1;
					}
					count = Math.max(count, box[i][j][k]);
				}
			}
		}
		if (count == 1) {
			return 0;
		} else {
			return count-1;
		}

	}

}
