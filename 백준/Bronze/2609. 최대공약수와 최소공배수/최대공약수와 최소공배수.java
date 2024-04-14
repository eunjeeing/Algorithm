import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num1 = Integer.parseInt(st.nextToken());
		int num2 = Integer.parseInt(st.nextToken());
		br.close();
		
		int a = Math.max(num1, num2);
		int b = Math.min(num1, num2);
		int r = 0;
		
		while(b != 0) {
			r = a % b;
			a = b;
			b = r;
		}
		System.out.println(a);
		System.out.println(num1 * num2 / a);
	}

}
