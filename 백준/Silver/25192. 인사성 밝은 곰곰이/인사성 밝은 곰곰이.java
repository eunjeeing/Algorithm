import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<String> set = new HashSet<>();
		int count = 0;
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			if(str.equals("ENTER")) {
				count += set.size(); 
				set = new HashSet<>();
			} else {
				set.add(str);
			}
		}
		System.out.println(count+set.size());
		
	}
}
