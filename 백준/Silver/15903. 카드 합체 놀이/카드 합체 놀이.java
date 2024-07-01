import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n = Long.parseLong(st.nextToken());
		long m = Long.parseLong(st.nextToken());
		long[] arr = new long[(int) n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		for (long i = 0; i < m; i++) {
			Arrays.sort(arr);
			long temp = arr[0] + arr[1];
			arr[0] = temp;
			arr[1] = temp;
			
		}
		
		long sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		System.out.println(sum);
		
		
	}

}
