import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			String str = br.readLine();
			if (str.equals("."))
				break;
			Stack<Character> stack = new Stack<>();
			boolean result = true;
			for (char ch : str.toCharArray()) {
				if (ch == '(' || ch == '[') {
					stack.push(ch);
				} else if (ch == ')') {
					if (stack.empty() || stack.peek() != '(')
						result = false;
					else
						stack.pop();
				} else if (ch == ']') {
					if (stack.empty() || stack.peek() != '[')
						result = false;
					else
						stack.pop();
				}

			}
			sb.append(stack.empty() && result == true ? "yes" : "no").append("\n");
		}
        br.close();
		System.out.println(sb);
	}
}
