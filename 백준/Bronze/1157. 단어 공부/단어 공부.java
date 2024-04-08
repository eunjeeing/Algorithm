import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Character, Integer> map = new HashMap<>();
		List<Character> list = new ArrayList<>();
		
		String s = br.readLine().toUpperCase();
		int max = 0; 

		br.close();
		
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			map.put(ch, map.getOrDefault(ch, 0) +1);
			max = Math.max(max, map.get(ch));
		}
		
		for(Character key : map.keySet()) {
			if(map.get(key) == max) {
				list.add(key);
			}
		}
		
		System.out.println(list.size() > 1 ? "?" : list.get(0));
	}
}