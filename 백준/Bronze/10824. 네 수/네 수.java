import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		br.close();
		
		long AB = Long.parseLong(st.nextToken()+st.nextToken());
		long CD = Long.parseLong(st.nextToken()+st.nextToken());
		
		System.out.println(AB+CD);
	}

}
