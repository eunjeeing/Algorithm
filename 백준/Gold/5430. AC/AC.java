import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			String p = br.readLine(); // 수행 함수
			int n = Integer.parseInt(br.readLine()); // 배열에 들어있는 수의 개수
			
			Deque<Integer> x = new ArrayDeque<>();
			Deque<Integer> reverseX = new ArrayDeque<>();
			String arrString = br.readLine(); // 배열
			StringTokenizer st = new StringTokenizer(arrString.substring(1, arrString.length()-1), ",");
			while(st.hasMoreTokens()) {
				int num = Integer.parseInt(st.nextToken());
				x.addLast(num);
				reverseX.addFirst(num);
			}
			boolean flag = true;
			for(char ch : p.toCharArray()) {
				if(ch == 'R') {
					Deque<Integer> temp = new ArrayDeque<>();
					temp = x;
					x = reverseX;
					reverseX = temp;
				} else if (ch == 'D') {
					if(x.size() > 0) {
						x.removeFirst();
						reverseX.removeLast();
					} else if (x.size() == 0) {
						sb.append("error").append("\n");
						flag = false;
						break;
					}
				}
			}
			if(flag) {
				sb.append("[");
				while(!x.isEmpty()) {
					if(x.size() > 1) sb.append(x.removeFirst()).append(",");
					else sb.append(x.removeFirst());
				}
				sb.append("]").append("\n");
			}
		}
		System.out.print(sb);
	}
}
