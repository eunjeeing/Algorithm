import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			boolean b = true;
			int num = Integer.parseInt(st.nextToken());
						
			if(num < 2) b = false;
			else if(num == 2) b = true;
			else {
				for(int j = 2; j < num; j++) {
					if(num % j == 0) b = false;
				}
			}
			
			if(b == true) count++;
				
		}
		br.close();
		System.out.println(count);
		
	}

}