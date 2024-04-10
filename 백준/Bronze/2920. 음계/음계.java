import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine().replaceAll(" ", "");
		br.close();
		if(s.equals("12345678")) System.out.println("ascending");
		else if(s.equals("87654321")) System.out.println("descending");
		else System.out.println("mixed");
	}
}