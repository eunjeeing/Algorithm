import java.io.*;
import java.math.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		BigInteger result = new BigInteger("1");
		for (int i = 1; i <= N; i++) {
			result = result.multiply(new BigInteger(i+""));
		}
		
		String factorial = result + "";
		
		int count = 0;
		for(int i = factorial.length()-1; i > 0; i--) {
			if (factorial.charAt(i) == '0') count++;
			else break;
		}
		System.out.println(count);
	}

}
