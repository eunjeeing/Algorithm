import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(list);
		int sum = 0;
		int result = 0;
		for (int i: list) {
			sum += i;
			result += sum;
		}
		System.out.println(result);
	}

}
