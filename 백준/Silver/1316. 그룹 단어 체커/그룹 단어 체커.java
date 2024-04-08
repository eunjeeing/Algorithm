import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = N;
		
		for(int i = 0; i < N; i++) {
			boolean[] boolArr = new boolean[26];
			String s = br.readLine();
			
			for(int j = 0; j < s.length(); j++) {
				if(boolArr[s.charAt(j)-'a'] == false) {
					boolArr[s.charAt(j)-'a'] = true;
				} else if (j > 0 && s.charAt(j) != s.charAt(j-1)) {
					count--;
					break;
				}
			}
		}
		br.close();
		System.out.println(count);
	}

}