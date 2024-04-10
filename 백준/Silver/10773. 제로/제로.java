import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		int sum = 0;
		
		for(int i = 0; i < K; i++) {
			
			int a = Integer.parseInt(br.readLine());
			
			if(a != 0) {
				list.add(a);
			} else {
				list.remove(list.size()-1);
			}
		}
		
		br.close();
		
		for(int i : list) {
			sum += i;
		}
		System.out.println(sum);
		
			
	}
}