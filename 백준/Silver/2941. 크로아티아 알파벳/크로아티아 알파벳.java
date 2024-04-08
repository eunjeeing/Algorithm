import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] arr = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		
		String word = br.readLine();
		br.close();
		
		for(String s : arr) {
			word = word.replace(s, "0");
		}
		System.out.println(word.length());
	}
}