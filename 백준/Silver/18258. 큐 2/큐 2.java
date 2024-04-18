import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			switch(cmd) {
				case "push":
					queue.offer(Integer.parseInt(st.nextToken()));
					break;
				case "pop": 
					if(queue.size() != 0) sb.append(queue.pollFirst()).append("\n");
					else sb.append(-1).append("\n");
					break;
				case "empty":
					sb.append(queue.isEmpty() ? "1" : "0").append("\n");
					break;
				case "size":
					sb.append(queue.size()).append("\n");
					break;
				case "front":
					if(queue.size() != 0) sb.append(queue.peekFirst()).append("\n");
					else sb.append(-1).append("\n");
					break;
				case "back":
					if(queue.size() != 0) {
						sb.append(queue.peekLast()).append("\n");
					} else {
						sb.append(-1).append("\n");
					}
					break;
				} 
			}
		br.close();
		System.out.println(sb);

	}

}