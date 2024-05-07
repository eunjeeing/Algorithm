import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][2];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			arr[i][0] = weight;
			arr[i][1] = height;	
		}
		
		for(int i = 0; i < N; i++) {
			int rank = 0;
			int weight_temp = arr[i][0];
			int height_temp = arr[i][1];
			for(int j = 0; j < N; j++) {
				if(weight_temp < arr[j][0] && height_temp < arr[j][1]) {
					rank++;
				}
			}
			System.out.print(rank+1 + " ");

		}
		

		
	}

}
