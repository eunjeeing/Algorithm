import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<String> set = new HashSet<>();
		set.add("ChongChong");
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String human1 = st.nextToken();
			String human2 = st.nextToken();

			if(set.contains(human1) || set.contains(human2)) {
				set.add(human1);
				set.add(human2);
			}

		}
		System.out.println(set.size());
		
	}

}
