import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			// 테스트케이스 마지막 줄
			if(a == 0 && b == 0 && c == 0) break;
			
			// a^2 + b^2 = c^2 라면 직각삼각형
			if(c > a && c > b) {
				if((int) Math.pow(a, 2) + (int) Math.pow(b, 2) == (int) Math.pow(c, 2)) sb.append("right\n");
				else sb.append("wrong\n");
			} else if(a > b && a > c) {
				if((int) Math.pow(b, 2) + (int) Math.pow(c, 2) == (int) Math.pow(a, 2)) sb.append("right\n");
				else sb.append("wrong\n");
			} else {
				if((int) Math.pow(a, 2) + (int) Math.pow(c, 2) == (int) Math.pow(b, 2)) sb.append("right\n");
				else sb.append("wrong\n");
			}

			
		}
		br.close();
		System.out.println(sb);
		
	}

}
