import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int res = 0;
		for (int i = N-1; i > 0; i--) {
			int j = i - 1;
			
			if (arr[i] <= arr[j]) {
				int num = arr[j];
				arr[j] = arr[i] - 1;
				res += num - arr[j];
			}
		}
		System.out.println(res);
	}

}