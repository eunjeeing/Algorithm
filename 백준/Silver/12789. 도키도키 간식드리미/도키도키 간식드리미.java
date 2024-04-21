import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> queue = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			queue.offer(Integer.parseInt(st.nextToken()));
		}
		
		int idx = 1;
		while(!queue.isEmpty()) {
			if(queue.peek() == idx) {
				queue.poll();
				idx++;
			} else if(!stack.isEmpty() && stack.peek() == idx) {
				stack.pop();
				idx++;
			} else {
				stack.push(queue.poll());
			}
		}
		
		while(!stack.isEmpty()) {
			if(stack.peek() == idx) {
				stack.pop();
				idx++;
			} else {
				System.out.println("Sad");
				return;
			}
		}
		System.out.println("Nice");
		
	}

}
