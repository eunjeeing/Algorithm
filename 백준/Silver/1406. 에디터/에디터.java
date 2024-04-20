import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> lstack = new Stack<>(); // 왼쪽 스택
		Stack<Character> rstack = new Stack<>(); // 오른쪽 스택 
		String str = br.readLine(); // 문자열
		for (char ch : str.toCharArray()) {
			lstack.push(ch);
		}
				
		int M = Integer.parseInt(br.readLine()); // 명령어 개수

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char cmd = st.nextToken().charAt(0);
			switch (cmd) {
				case 'L': 
					if (!lstack.isEmpty()) rstack.push(lstack.pop());
					break;
				case 'D':
					if (!rstack.isEmpty()) lstack.push(rstack.pop());
					break;
				case 'B':
					if (!lstack.isEmpty()) lstack.pop();
					break;
				case 'P':
					lstack.push(st.nextToken().charAt(0));
			}
		}

		while(!lstack.isEmpty()) {
			rstack.push(lstack.pop());
		}
		while(!rstack.isEmpty()) {
			sb.append(rstack.pop());
		}
		System.out.println(sb);
	}

}
