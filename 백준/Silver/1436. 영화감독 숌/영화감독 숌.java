import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
        br.close();
        
		int num = 666;
		int count = 1;
		
		while(count != N) {
			num++;
			
			if(String.valueOf(num).contains("666")) {
				count++;
			}
		}
		System.out.println(num);

	}

}
