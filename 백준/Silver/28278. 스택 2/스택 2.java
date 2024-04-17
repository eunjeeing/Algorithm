import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			switch(cmd) {
				case 1:
					stack.push(Integer.parseInt(st.nextToken()));
					break;
				case 2: 
					if(stack.size() != 0) sb.append(stack.pop()).append("\n");
					else sb.append(-1).append("\n");
					break;
				case 3:
					sb.append(stack.size()).append("\n");
					break;
				case 4:
					sb.append(stack.isEmpty() ? "1" : "0").append("\n");
					break;
				case 5:
					if(stack.size() != 0) sb.append(stack.peek()).append("\n");
					else sb.append(-1).append("\n");
					break;
			}
		}
		br.close();
		System.out.println(sb);
		
	}
}
