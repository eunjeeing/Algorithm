import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int a = (int) Math.round(n * 0.15);
		
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			arr[i] = num;
		}
		Arrays.sort(arr);
		List<Integer> list = new ArrayList<>();
		for(int i = a; i < n-a; i++) {			
			list.add(arr[i]);
		}
		
		double sum = 0.0;
		for (int i : list) {
			sum += i;
		}
		
		double avg = sum/list.size();
		System.out.println((int) Math.round(avg));
	}

}
