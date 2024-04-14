import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Map<String, String> map = new HashMap<>();
		Map<String, String> map2 = new HashMap<>();
		for (int i = 1; i <= N; i++) {
			String s = br.readLine();
			map.put(i + "", s);
			map2.put(s, i+"");
		}
		
		ArrayList<String> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			list.add(br.readLine());
		}
        br.close();
		for(int i = 0; i < list.size(); i++) {
			if(map.containsKey(list.get(i))) sb.append(map.get(list.get(i))).append("\n");
			else if(map2.containsKey(list.get(i))) sb.append(map2.get(list.get(i))).append("\n");
		}
		System.out.println(sb);
	}
}
