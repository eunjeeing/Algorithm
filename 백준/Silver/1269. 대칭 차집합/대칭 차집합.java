import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<Integer> A = new HashSet<>();
		HashSet<Integer> B = new HashSet<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 집합 A 입력 받기 
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A.add(Integer.parseInt(st.nextToken()));
		}
		
		// 집합 B 입력 받기 
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			B.add(Integer.parseInt(st.nextToken()));
		}
		br.close();
		int ab = 0;
		int ba = 0;
		
		Iterator<Integer> iter = A.iterator();
		while(iter.hasNext()) {
			if(B.contains(iter.next())) ab++;	
		}
		
		Iterator<Integer> iter2 = B.iterator();
		while(iter2.hasNext()) {
			if(A.contains(iter2.next())) ba++;
		}
        
		System.out.println((N-ab)+(M-ba));
	}
}
