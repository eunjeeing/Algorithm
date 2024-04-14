import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int getSolution(int startRow, int startCol, String[] board) {
		String[] orgBoard = {"WBWBWBWB", "BWBWBWBW"};
		int whiteSol = 0;
		for(int i = 0; i < 8; i++) {
			int row = startRow + i;
			for(int j = 0; j < 8; j++) {
				int col = startCol + j;
				if(board[row].charAt(col) != orgBoard[row%2].charAt(j)) whiteSol++;
			}
		}
		return Math.min(whiteSol, 64 - whiteSol);
	}
	
	public static void main(String[] args) throws Exception {
		// 1. 입력값 받기 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // row
		int M = Integer.parseInt(st.nextToken()); // col
		String[] board = new String[N];
		
		for(int i = 0; i < N; i++) board[i] = br.readLine();
		
		// 2. 체스판 자르기
		int sol = Integer.MAX_VALUE;
		for(int i = 0; i <= N-8; i++) {
			for(int j = 0; j <= M-8; j++) {
				int curSol = getSolution(i, j, board);
				if(sol > curSol) sol = curSol;
			}
		}
		br.close();
		System.out.println(sol);
		
	}
	


}
