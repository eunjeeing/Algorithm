import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			LinkedList<int[]> q = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				q.offer(new int[] { j, Integer.parseInt(st.nextToken()) });
			}

			int count = 0;

			while (!q.isEmpty()) {
				int[] temp = q.poll();
				boolean max = true;
				for (int j = 0; j < q.size(); j++) {
					if (temp[1] < q.get(j)[1]) {
						q.offer(temp);
						for (int k = 0; k < j; k++) {
							q.offer(q.poll());
						}
						max = false;
						break;
					}
				}
				if (!max) {
					continue;
				}

				count++;
				if (temp[0] == M) {
					break;
				}

			}

			sb.append(count).append("\n");

		}
		System.out.println(sb);
	}

}
