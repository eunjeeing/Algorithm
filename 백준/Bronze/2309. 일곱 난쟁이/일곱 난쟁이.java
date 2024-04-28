import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[9];
		int total = 0;
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			total += arr[i];
		}
		
		br.close();
		Arrays.sort(arr);
		
		int num1 = 0, num2 = 0;
		
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if(arr[i] + arr[j] == (total - 100)) {
					num1 = arr[i];
					num2 = arr[j];
				}
			}
		}
		
		for(int i : arr) {
			if(i != num1 && i != num2) {
				sb.append(i).append("\n");
			}
		}
		
		System.out.println(sb);
		
	}

}
