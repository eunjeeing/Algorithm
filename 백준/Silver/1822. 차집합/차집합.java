import java.util.*;
import java.io.*;


public class Main {
	
	static int[] arr, arr2;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // A 원소 개수
		int M = Integer.parseInt(st.nextToken()); // B 원소 개수
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
				
		List<Integer> list = new ArrayList<>();
		arr2 = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr2);
		
		for(int i : arr) {
			if(binarySearch(i) == 0) {
				list.add(i);
			}
		}
		
		sb.append(list.size()).append("\n");
        Collections.sort(list);
		if (list.size() > 0) {
			for(int i : list) {
				sb.append(i).append(" ");
			}
		}
		System.out.println(sb);
		
	}
	public static int binarySearch(int num) {
		int low = 0;
		int high = arr2.length-1;
		int mid;
		
		while(low <= high) {
			mid = (low + high) / 2;
			
			if(num < arr2[mid]) {
				high = mid - 1;
			} else if (num > arr2[mid]) {
				low = mid + 1;
			} else {
				return 1;
			}
			
		}
		return 0;
	}
}
