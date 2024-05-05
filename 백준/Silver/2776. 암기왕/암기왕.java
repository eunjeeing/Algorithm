import java.util.*;
import java.io.*;

public class Main {	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()); // 테스트케이스 개수 
		for (int i = 0; i < T; i++) {
			
			int N = Integer.parseInt(br.readLine()); // 수첩1 
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			
			int M = Integer.parseInt(br.readLine()); // 수첩2 
			st = new StringTokenizer(br.readLine());
			for (int k = 0; k < M; k++) {
				int num = Integer.parseInt(st.nextToken());
				sb.append(binarySearch(num, arr)).append("\n");
			}
		}
		System.out.println(sb);
		
	}
	
	public static int binarySearch(int num, int[] arr) {
		int low = 0;
		int high = arr.length-1;
		int mid;
		
		while (low <= high) {
			mid = (low+high)/2;
			if(num > arr[mid]) {
				low = mid + 1;
			} else if (num < arr[mid]) {
				high = mid - 1;
			} else {
				return 1;
			}
		}
		return 0;
	}
}
