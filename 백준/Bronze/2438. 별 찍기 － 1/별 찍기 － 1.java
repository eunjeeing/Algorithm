import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		String answer = "";
		
		for(int i = 1; i <= t; i++) {
			answer += "*";
			System.out.println(answer);
		}
	}
}