import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[9];
		int max = 0;
		int max_idx = 0;
		for(int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(arr[i] > max) {
				max = arr[i];
				max_idx = i+1;
			}
		}
		br.close();
		
		System.out.println(max);
		System.out.println(max_idx);

	}
}