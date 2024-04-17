import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			switch(s) {
				case "push_front": 
					deque.offerFirst(Integer.parseInt(st.nextToken()));
					break;
				case "push_back":
					deque.offerLast(Integer.parseInt(st.nextToken()));
					break;
				case "pop_front":
					if(deque.size() != 0) sb.append(deque.pollFirst()).append("\n");
					else sb.append(-1).append("\n");
					break;
				case "pop_back":
					if(deque.size() != 0) sb.append(deque.pollLast()).append("\n");
					else sb.append(-1).append("\n");
					break;
				case "size":
					sb.append(deque.size()).append("\n");
					break;
				case "empty":
					sb.append(deque.isEmpty() ? "1" : "0").append("\n");
					break;
				case "front":
					if(deque.size() != 0) sb.append(deque.peekFirst()).append("\n");
					else sb.append(-1).append("\n");
					break;
				case "back":
					if(deque.size() != 0) sb.append(deque.peekLast()).append("\n");
					else sb.append(-1).append("\n");
					break;
				}
		}
		br.close();
		System.out.println(sb);
	}

}
