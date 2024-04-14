import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> map = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			map.put(br.readLine(), 1);
		}
		
		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			if(map.containsKey(s)) map.put(s, map.getOrDefault(map.get(s), 1)+1);
		}
		br.close();
		
		ArrayList<String> list = new ArrayList<>();
		int sum = 0;
		for (Map.Entry<String, Integer> item : map.entrySet()) {
			if(item.getValue() == 2) {
				list.add(item.getKey());
				sum++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(sum).append("\n");
		Collections.sort(list);
		for(String s : list) {
			sb.append(s).append("\n");
		}
		System.out.println(sb);

	}

}
