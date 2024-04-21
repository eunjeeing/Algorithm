import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean flag = false;
		Stack<Character> stack = new Stack<>();
		String S = br.readLine();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < S.length(); i++) {
			if(S.charAt(i) == '<') {
				flag = true;
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append(S.charAt(i));
			} else if (S.charAt(i) == '>') {
				flag = false;
				sb.append(S.charAt(i));
			} else if (flag) {
				sb.append(S.charAt(i));
			} else if (!flag) {
				if (S.charAt(i) == ' ') {
					while(!stack.isEmpty()) {
						sb.append(stack.pop());
					}
					sb.append(S.charAt(i));
				} else {
					stack.push(S.charAt(i));
				}
			}
		}
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb.toString());
		

	}

}