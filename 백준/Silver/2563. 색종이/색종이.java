import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[100][100];
		int count = 0;
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken()); 
			int Y = Integer.parseInt(st.nextToken()); 
			
			for(int j = 0; j < 10; j++) {
				for(int m = 0; m < 10; m++) {
					arr[X+j][Y+m]++;
					if(arr[X+j][Y+m] == 1) count++;
				}

			}
			
		}
        br.close();
		System.out.println(count);

	}

}