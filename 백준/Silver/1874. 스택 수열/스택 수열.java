import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int temp = 1;
		boolean result = true;
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			while(temp <= num) {
				stack.push(temp);
				sb.append("+").append("\n");
				temp++;
			} 
			if (stack.peek() == num) {
				stack.pop();
				sb.append("-").append("\n");
			} else {
				result = false;
			}
		}
		System.out.println(result ? sb : "NO");
	
	}

}
