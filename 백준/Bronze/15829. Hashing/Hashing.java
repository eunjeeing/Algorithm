import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		int sum = 0;
		String str = br.readLine();
		for (int i = 0; i < L; i++) {
			sum += (str.charAt(i) - 96) * (int) Math.pow(31, i);
		}
		System.out.println(sum);
		
	}

}
