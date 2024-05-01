import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static boolean[][] visited;
	static char[][] image;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		image = new char[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				image[i][j] = str.charAt(j);
			}
		}
		
		// 적록색약이 아닌 사람이 봤을 경우 
		int count1 = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					dfs(i, j);
					count1++;
				}
			}
		}
		
		// 적록색약인 사람이 봤을 경우
		// G -> R
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(image[i][j] == 'G') image[i][j] = 'R';
			}
		}
				
		visited = new boolean[N][N];
		int count2 = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					dfs(i, j);
					count2++;
				}
			}
		}
		
		System.out.println(count1 + " " + count2);
		
		
	}
	
	static void dfs(int x, int y) {
		if(visited[x][y]) return;
		char color = image[x][y];
		visited[x][y] = true;
		for(int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
				if(!visited[nextX][nextY] && image[nextX][nextY] == color) {
					dfs(nextX, nextY);
				}
			}
		}
	}

}
