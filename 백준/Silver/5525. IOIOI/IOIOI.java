import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String P = "";
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String S = br.readLine();
		
		for (int i = 0; i < N; i++) {
			P += "IO";
		}
		P += "I";
		
		int idx = 0;
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < M; i++) {
			idx = S.indexOf(P, i);
			set.add(idx);
		}
		set.remove(-1);
		System.out.println(set.size());
	}

}
