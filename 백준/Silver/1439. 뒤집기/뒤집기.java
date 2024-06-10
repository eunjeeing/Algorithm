import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		int count0 = 0;
		int count1 = 0;
		for (int i = 0; i < S.length()-1; i++) {
			if (S.charAt(i) != S.charAt(i+1)) {
				if (S.charAt(i) == '0') {
					count0++;
				} else {
					count1++;
				}
			} 
		}
		System.out.println(Math.max(count0, count1));
	}

}