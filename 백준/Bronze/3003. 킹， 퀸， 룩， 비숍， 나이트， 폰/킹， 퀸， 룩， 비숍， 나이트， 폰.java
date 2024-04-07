import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		int[] chess = {1, 1, 2, 2, 2, 8};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[6];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			System.out.print(chess[i] - arr[i] + " ");
		}
	}
}