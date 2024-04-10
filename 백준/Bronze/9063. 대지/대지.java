import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int x[] = new int[N];
		int y[] = new int[N];

		int x_min = 10000, y_min = 10000;
		int x_max = -10000, y_max = -10000;
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}
		br.close();

		for(int i = 0; i < N; i++) {
			x_max = Math.max(x[i], x_max);
			y_max = Math.max(y[i], y_max);
			x_min = Math.min(x[i], x_min);
			y_min = Math.min(y[i], y_min);
			
		}
		
		System.out.println((x_max-x_min) * (y_max-y_min));
		
	}

}