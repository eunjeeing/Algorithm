import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashSet<Integer> set = new HashSet<>();
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			set.add(num);
			arr[i] = num;
		}
		br.close();
		
		ArrayList<Integer> list = new ArrayList<>(set);
		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			sb.append(binary(list, arr[i])).append(" ");
		}
		System.out.println(sb);
		
	}
	
	public static int binary(ArrayList<Integer> a, int data) {
			int start = 0;
			int end = a.size();

			while (start < end) {
				int mid = (start + end) / 2; 
				if (a.get(mid) >= data) { 
					end = mid; 
				} else {
					start = mid + 1; 
				}
			}

			return end; 
		}
}
