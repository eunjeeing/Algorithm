import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] x_asix = new int[3];
		int[] y_asix = new int[3];

		
		for(int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			x_asix[i] = Integer.parseInt(st.nextToken());
			y_asix[i] = Integer.parseInt(st.nextToken());

		}
		
		br.close();
		
		int x, y = 0;
		
		if(x_asix[0] == x_asix[1]) {
			x = x_asix[2];
		}
		else {
			x = x_asix[1] == x_asix[2] ? x_asix[0] : x_asix[1];
		}
		if(y_asix[0] == y_asix[1]) {
			y = y_asix[2];
		} else {
			y = y_asix[1] == y_asix[2] ? y_asix[0] : y_asix[1];
		}
		
		System.out.println(x + " " + y);
	}

}