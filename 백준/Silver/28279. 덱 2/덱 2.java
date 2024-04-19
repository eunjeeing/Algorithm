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
			int cmd = Integer.parseInt(st.nextToken());
			switch(cmd) {
				case 1: 
					deque.offerFirst(Integer.parseInt(st.nextToken()));
					break;
				case 2:
					deque.offerLast(Integer.parseInt(st.nextToken()));
					break;
				case 3:
					if(deque.size() != 0) sb.append(deque.pollFirst()).append("\n");
					else sb.append(-1).append("\n");
					break;
				case 4:
					if(deque.size() != 0) sb.append(deque.pollLast()).append("\n");
					else sb.append(-1).append("\n");
					break;
				case 5:
					sb.append(deque.size()).append("\n");
					break;
				case 6:
					sb.append(deque.isEmpty() ? "1" : "0").append("\n");
					break;
				case 7:
					if(deque.size() != 0) sb.append(deque.peekFirst()).append("\n");
					else sb.append(-1).append("\n");
					break;
				case 8:
					if(deque.size() != 0) sb.append(deque.peekLast()).append("\n");
					else sb.append(-1).append("\n");
					break;
				}
		}
		br.close();
		System.out.println(sb);
	}

}