import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 나무의 수 
		int M = Integer.parseInt(st.nextToken()); // 가져가려는 나무의 길이
		
		int[] arr = new int[N];
		long min = 0;
		long max = 0;
		long mid = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}
		
		while (min < max) {
			mid = (max+min)/2;
			long height = 0;
			
			for(int i = 0; i < arr.length; i++) {
				if(arr[i] - mid > 0) height += (arr[i]-mid);
			}

			if(height < M) {
				max = mid;
			} else {
				min = mid + 1;
			}
			
		}
		
		System.out.println(min-1);
	}

}
