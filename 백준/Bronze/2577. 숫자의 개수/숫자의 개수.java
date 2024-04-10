import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		br.close();
		
		int[] arr = new int[10];
		String sum = A*B*C+"";
		
		for(int i = 0; i < sum.length(); i++) {
			arr[sum.charAt(i)-'0'] += 1;
		}
		 
		for(int i : arr) {
			System.out.println(i);
		}
		
	}
}