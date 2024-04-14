import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 집합 문자열 
		int M = Integer.parseInt(st.nextToken()); // 검사 문자열 
		
		HashMap<String, Integer> map = new HashMap<>();
		// 집합 문자열 입력 
		for(int i = 0; i < N; i++) {
			map.put(br.readLine(), 0);
		}
		
		// 검사 문자열을 입력 받고 Map에 있는 문자열이라면 Value에 1씩 더하기 
		for(int i = 0; i < M; i++) {
			String s = br.readLine();
			if(map.containsKey(s)) map.replace(s, map.get(s)+1);
		}
		
		int sum = 0;
        Collection<Integer> values = map.values();     
        for (Integer v : values) {
            sum += v;
        }
        System.out.println(sum);
    }

}
