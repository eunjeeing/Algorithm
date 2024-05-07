import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		int[][] apt = new int[15][15];
		
		for (int i = 0; i < 15; i++) {
			apt[i][1] = 1;
			apt[0][i] = i;
		}
		
		for (int i = 1; i < 15; i++) { // 1층 ~ 14층 
			for (int j = 2; j < 15; j++) { // 2호 ~ 14호 
				apt[i][j] = apt[i][j-1] + apt[i-1][j];
			}
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			System.out.println(apt[k][n]);
			
		}
	}
	
}
