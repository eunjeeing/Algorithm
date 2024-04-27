import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
			int abs1 = Math.abs(o1);
			int abs2 = Math.abs(o2);
			
			if(abs1 == abs2) return o1 > o2 ? 1 : -1;
			return abs1 - abs2;
		});
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x != 0) {
				pq.offer(x);
			} else {
				if(!pq.isEmpty()) {
					sb.append(pq.poll()).append("\n");
				} else {
					sb.append("0").append("\n");
				}
			}
		}
		br.close();
		System.out.println(sb);
	}

}
