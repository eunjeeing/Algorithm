import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			HashMap<String, Integer> map = new HashMap<>();
			int N = Integer.parseInt(br.readLine());
			int count = 1;
			for(int j = 0; j < N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();
				String category = st.nextToken();
				map.put(category, map.getOrDefault(category, 0)+1);
			}
			
			for (int k : map.values()) {
				count *= (k+1);
			}
			System.out.println(count-1);
			
		}
	}

}
