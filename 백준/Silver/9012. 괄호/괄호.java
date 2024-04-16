import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			Stack<Character> stack = new Stack<>();
			String s = br.readLine();
			boolean result = true;
			for(char ch : s.toCharArray()) {
				if(ch == '(') {
					stack.push('(');
				} else {
					if(stack.empty()) result = false;
					else stack.pop();
				}
			}
			System.out.println(stack.empty() && result == true ? "YES" : "NO");
		}
	}
}
