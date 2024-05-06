import java.util.*;
import java.io.*;

// 과자 나눠주기 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken()); // 조카의 수 
		int N = Integer.parseInt(st.nextToken()); // 과자의 수 
		int[] arr = new int[N];
		
		int max = 0;
		int min = 1;
		int mid = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}
		
		while(min <= max) {
			mid = (min+max)/2;
			
			int count = 0;
			for(int i = 0; i < N; i++) {
				if(arr[i] - mid >= 0) count += (arr[i]/mid);
			}
			if(count >= M) {
				min = mid + 1;
			} else {
				max = mid -1;
			}
			
		}
		
		System.out.println(max);
		
	}

}
