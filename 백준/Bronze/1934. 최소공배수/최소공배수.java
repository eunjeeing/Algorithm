import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			
			int a = Math.max(num1, num2);
			int b = Math.min(num1, num2);
			int r = 0;
			
			while(b != 0) {
				r = a % b;
				a = b;
				b = r;
			}
			System.out.println(num1 * num2 / a);
		}
		br.close();

 	}

}
