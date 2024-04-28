import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().toUpperCase();
		int[] alphabet = new int[26];
		
		for (int i = 0; i < str.length(); i++) {
			alphabet[str.charAt(i)-65]++;
		}
		
		int max = alphabet[0];
		char result = 'A';
		
		for(int i = 1; i < alphabet.length; i++) {
			if(max < alphabet[i]) {
				max = alphabet[i];
				result = (char) (i+65);
			} else if (max == alphabet[i]) {
				result = '?';
			}
		}
		System.out.println(result);
	}

}