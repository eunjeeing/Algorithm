import java.io.*;
import java.util.*;

public class Main {
	public static long five(long num) {
		int count = 0;
		
		while (num >= 5) {
			count += (num / 5);
			num /=5;
		}
		return count;
	}
	
	public static long two(long num) {
		int count = 0;
		while (num >= 2) {
			count += (num /2);
			num /= 2;
		}
		return count;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n = Long.parseLong(st.nextToken());
		long m = Long.parseLong(st.nextToken());
		
		long count_five = five(n) - five(n-m) - five(m);
		long count_two = two(n) - two(n-m) - two(m);
		
		br.close();
		System.out.println(Math.min(count_five, count_two));
		
	}

}
