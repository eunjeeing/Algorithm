import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		long n = Integer.parseInt(br.readLine());
		HashSet<String> set = new HashSet<>();
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String status = st.nextToken();
			if(status.equals("enter")) set.add(name);
			else if(status.equals("leave")) set.remove(name);
		}
		
		br.close();
		
		ArrayList<String> list = new ArrayList<>(set); 
		Collections.sort(list, Collections.reverseOrder()); 
		
		for(String str : list) sb.append(str + "\n");
		System.out.println(sb); 
	}

}
