import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		LinkedList<Integer> dq = new LinkedList<>();
		int count = 0;
		int N = Integer.parseInt(st.nextToken()); // 큐의 크기 
		int M = Integer.parseInt(st.nextToken()); // 구하려는 수의 개수 
		
		for(int i = 1; i <= N; i++) {
			dq.offer(i);
		}
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[M];
		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < M; i++) {
			while(dq.peekFirst() != arr[i]) {
				if(dq.indexOf(arr[i]) <= dq.size()/2) {
					dq.offerLast(dq.pollFirst());
				} else {
					dq.offerFirst(dq.pollLast());
				}
				count++;
			}
			dq.poll();
		}
		br.close();
		System.out.println(count);
	}

}
