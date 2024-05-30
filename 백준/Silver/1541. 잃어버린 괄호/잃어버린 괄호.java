import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), "-");
		int result = Integer.MAX_VALUE;
		while(st.hasMoreTokens()) {
			int temp = 0;
			StringTokenizer st2 = new StringTokenizer(st.nextToken(), "+");
			while(st2.hasMoreTokens()) {
				temp += Integer.parseInt(st2.nextToken());
			}
			if(result == Integer.MAX_VALUE) {
				result = temp;
			} else {
				result -= temp;
			}
		}
		System.out.print(result);
	}

}
