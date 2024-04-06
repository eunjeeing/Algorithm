import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		double[] arr = new double[N];
		double avg = 0.0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		double M = 0.0;
		for(int i = 0; i < N; i++) {
			arr[i] = Double.parseDouble(st.nextToken());
			M = Math.max(M, arr[i]);
		}
        br.close();
		
		for(int i = 0; i < arr.length; i++) {
			avg += (arr[i]/M*100)/N;
		}
		
		System.out.println(avg);

	}
}