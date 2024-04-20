import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String S = br.readLine();
		br.close();
		for(char ch : S.toCharArray()) {
			int ROT13 = 0;
			if((ch >= 'A' && ch <= 'M') || (ch >= 'a' && ch <= 'm')) {
				ROT13 = (int) ch + 13;
				sb.append((char)ROT13);
			} else if ((ch >= 'N' && ch <= 'Z') || (ch >= 'n' && ch <= 'z')) {
				ROT13 = (int) ch - 13;
				sb.append((char)ROT13);
			} else {
				sb.append(ch);
			}
		}
		System.out.println(sb);
	}

}
