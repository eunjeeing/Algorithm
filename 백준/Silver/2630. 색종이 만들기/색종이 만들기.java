import java.util.*;
import java.io.*;

public class Main {
	
	static int whiteCnt = 0;
	static int blueCnt = 0;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		divide(0, 0, N);
		System.out.println(whiteCnt);
		System.out.println(blueCnt);

	}
	
	public static void divide(int row, int col, int length) {
		if(check(row, col, length)) {
			if(arr[row][col] == 0) {
				whiteCnt++;
			}
			else {
				blueCnt++;
			}
			return;
		}
		
		int halfLength = length / 2;
		
		divide(row, col, halfLength);
		divide(row, col+halfLength, halfLength);
		divide(row+halfLength, col, halfLength);
		divide(row+halfLength, col+halfLength, halfLength);
		
	}
	
	public static boolean check(int row, int col, int length) {
		int color = arr[row][col];
		
		for(int i = row; i < row + length; i++) {
			for(int j = col; j < col + length; j++) {
				if(arr[i][j] != color) {
					return false;
				}
			}
		}
		
		return true;
	}

}
