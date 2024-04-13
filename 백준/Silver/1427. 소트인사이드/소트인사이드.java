import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String N = br.readLine();
		br.close();
		
		ArrayList<Integer> list = new ArrayList<>();
		for(String s : N.split("")) {
			list.add(Integer.parseInt(s));
		}
		
		Collections.sort(list, Collections.reverseOrder());
		
		for(int i : list) {
			sb.append(i+"");
		}
		
		System.out.println(sb);
		
	}
}
