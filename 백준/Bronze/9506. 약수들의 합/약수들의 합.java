import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		while(true) {

			int n = Integer.parseInt(br.readLine());
			
			if(n == -1 )break;

			ArrayList<Integer> list = new ArrayList<>();
			StringBuilder sb = new StringBuilder();
			int sum = 0;

			for(int i = 1; i < n; i++) {
				if(n % i == 0) {
					list.add(i);
					sum += i;
				}
			}
			
			if(sum == n) {
				sb.append(n + " =");
				for(int i = 0; i < list.size(); i++) {
					sb.append(" " + list.get(i));
					if(i != list.size()-1) sb.append(" +");
				}
			} else {
				sb.append(n + " is NOT perfect.");
			}

			System.out.println(sb);

		}
		br.close();
		
	}

}