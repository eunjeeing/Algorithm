import java.io.*;
import java.util.*;

public class Main {
	
	public static int gcd(int a, int b) {
		if (b == 0) return a;
		else return gcd(b, a % b);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[n];
			long sum = 0;
			
			for (int j = 0 ; j < n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			for (int m = 0; m < arr.length-1 ; m++) {
				for (int k = m+1; k < arr.length; k++) {
					if(arr[m] > arr[k]) sum += gcd(arr[m], arr[k]);
					else sum += gcd(arr[k], arr[m]);
				}
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);

	}
	

}
