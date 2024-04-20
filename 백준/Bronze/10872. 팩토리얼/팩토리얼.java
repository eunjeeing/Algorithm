import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		br.close();
		int result = 1;
		for (int i = N; i > 0; i--) {
			result *= i;
		}
		System.out.println(result);
	}
}