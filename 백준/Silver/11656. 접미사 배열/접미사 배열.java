import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		String S = br.readLine();
		for (int i = 0; i < S.length(); i++) {
			list.add(S.substring(i));
		}
		list.sort(Comparator.naturalOrder());
		
		for(String s: list) {
			sb.append(s).append("\n");
		}
		System.out.println(sb);
	}

}
