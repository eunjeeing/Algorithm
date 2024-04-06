import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int temp = 0;
		for(int i = 0; i < N; i++) {
			arr[i] = i+1;
		}	
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int I = Integer.parseInt(st.nextToken());
			int J = Integer.parseInt(st.nextToken());
			
			temp = arr[J-1]; 
			arr[J-1] = arr[I-1]; 
			arr[I-1] = temp; 
		}
		br.close();
		
		for(int i : arr) {
			System.out.print(i + " ");
		}

	}
}