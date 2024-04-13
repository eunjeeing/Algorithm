import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int result = 0;

		for (int i = 1; i <= N; i++) {
			String num = i + "";
			int sum = 0;
			for (int j = 0; j < num.length(); j++) {
				sum += num.charAt(j)-'0';
			}
			if (sum + Integer.parseInt(num) == N) {
				result = Integer.parseInt(num);
				System.out.println(result);
					break;
			}

		}
		if (result == 0) {
			System.out.println(0);

		}

	}

}
