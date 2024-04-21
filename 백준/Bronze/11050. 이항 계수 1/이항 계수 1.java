import java.io.*;
import java.util.*;

public class Main {
	public static int factorial(int num) {
		if(num <= 1) return 1;
		return num*factorial(num-1);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		br.close();
		System.out.println(factorial(N)/(factorial(K)*factorial(N-K)));
		
	}

}
