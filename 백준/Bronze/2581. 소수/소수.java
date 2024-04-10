import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
				
		ArrayList<Integer> list = new ArrayList<>();
		
		int sum = 0;
		
		for(int i = M; i <= N; i++) {
			boolean b = true;
						
			if(i < 2) b = false;
			else if(i == 2) b = true;
			else {
				for(int j = 2; j < i; j++) {
					if(i % j == 0) b = false;
				}
			}
			
			if(b == true) list.add(i);
		
		}
		br.close();
		
		if(list.size() > 0) {
			for(int i : list) {
				sum += i;
			}
			System.out.println(sum);
			System.out.println(list.get(0));
		} else System.out.println(-1);

		
	}

}