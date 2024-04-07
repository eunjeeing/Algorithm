import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sum = 0;
		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		br.close();
		
		for(int i = 0; i < N; i++) {
			sum += Integer.parseInt(s.substring(i, i+1));
		}
		System.out.println(sum);
		
	}
}