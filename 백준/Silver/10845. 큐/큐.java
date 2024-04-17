import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> queue = new LinkedList<>();

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String cmd = br.readLine();
			if (cmd.equals("pop")) {
				if(queue.size() != 0) System.out.println(queue.remove());
				else System.out.println(-1);
			} else if (cmd.equals("size")) {
				System.out.println(queue.size());
			} else if (cmd.equals("empty")) {
				System.out.println(queue.isEmpty() ? "1" : "0");
			} else if (cmd.equals("front")) {
				if(queue.size() != 0) System.out.println(queue.peek());
				else System.out.println(-1);
			} else if (cmd.equals("back")) {
				if(queue.size() != 0) {
					Queue<Integer> queue2 = new LinkedList<>(queue);
					int size = queue2.size();
					while(size > 1) {
						queue2.poll();
						size--;
					}
					System.out.println(queue2.peek());
				}
				else System.out.println(-1);
			} else {
				StringTokenizer st = new StringTokenizer(cmd); 
				st.nextToken();
				queue.offer(Integer.parseInt(st.nextToken()));
			}
		}
	}

}
