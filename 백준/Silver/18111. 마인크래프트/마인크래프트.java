import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 세로 
		int M = Integer.parseInt(st.nextToken()); // 가로 
		int B = Integer.parseInt(st.nextToken()); // 인벤토리에 들어있는 블록의 수 
		
		int[][] arr = new int[N][M];
		int max = 0;
		int min = 256;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(arr[i][j], max);
				min = Math.min(arr[i][j], min);
			}
		}
		
		int time = 64000000;
		int height = 0;
		for (int i = min; i <= max; i++) {
			int count = 0;
			int inventory = B;
			for(int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if(i < arr[j][k]) {
						count += ((arr[j][k] - i) * 2);
						inventory += (arr[j][k] - i);
					}else if (i > arr[j][k]){
						count += (i - arr[j][k]);
						inventory -= (i - arr[j][k]);
					}
				}
			}
			if(inventory < 0) break;
			
			if(time >= count) {
				time = count;
				height = i;
			}
		}
		System.out.println(time + " " + height);

	}

}
