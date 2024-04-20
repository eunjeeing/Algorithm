import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input = "";
		while((input = br.readLine()) != null) {
			int[] arr = new int[4];
			for (char ch : input.toCharArray()) {
				if((int) ch >= 97 && (int) ch <= 122) arr[0]++;
				else if((int) ch >= 65 && (int) ch <= 95) arr[1]++;
				else if((int) ch >= 48 && (int) ch <= 57) arr[2]++;
				else arr[3]++;
			}
			
			for (int i : arr) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			
		}
		br.close();
		System.out.println(sb);
		
	}

}
