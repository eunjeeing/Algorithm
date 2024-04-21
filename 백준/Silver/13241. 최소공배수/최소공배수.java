import java.io.*;
import java.util.*;

public class Main {
	
	public static long gcd(long a, long b) {
		if(b == 0) return a;
		return gcd(b, a % b);
	}
	
	public static long lcm(long a, long b) {
		return a * b /gcd(a, b);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		if (A > B) {
			System.out.println(lcm(A,B));
		} else {
			System.out.println(lcm(B, A));
		}
	}

}
