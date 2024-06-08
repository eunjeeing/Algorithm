import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int count = 0;
		int[] memo = new int[M];
		char[] S = br.readLine().toCharArray();
		for (int i = 1; i < M - 1; i++) {
			if (S[i] == 'O' && S[i + 1] == 'I') {
				memo[i + 1] = memo[i - 1] + 1;
				if (memo[i + 1] >= N && S[i - 2 * N + 1] == 'I') {
					count++;
				}
			}
		}
		System.out.println(count);
	}

}
