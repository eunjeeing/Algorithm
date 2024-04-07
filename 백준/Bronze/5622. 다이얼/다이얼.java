import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		int count = 0;
		
		for(int i = 0; i < s.length(); i++) {
			int asc = (int)s.charAt(i);
			if(asc < 'D') count += 3;
			else if(asc < 'G') count += 4;
			else if(asc < 'J') count += 5;
			else if(asc < 'M') count += 6;
			else if(asc < 'P') count += 7;
			else if(asc < 'T') count += 8;
			else if(asc < 'W') count += 9;
			else count+= 10;
		}
		
		System.out.println(count);
	}
		
}