import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		Integer[] score = new Integer[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			score[i] =  Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(score, Collections.reverseOrder());
		sb.append(score[k-1]);
		System.out.println(sb);
	}
}
