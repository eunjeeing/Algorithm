import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Member[] member = new Member[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			
			member[i] = new Member(name, age);
			 
		}
		br.close();
		
		Arrays.sort(member, (Member m1, Member m2) -> m1.age - m2.age);
		StringBuilder sb = new StringBuilder();		

		for(int i = 0; i < member.length; i++) {
			sb.append(member[i].toString());
		}
		
		System.out.println(sb);
		
	}
	
	public static class Member {
		String name;
		int age;

		public Member(String name, int age) {
			this.name = name;
			this.age = age;
		}
		
		@Override
		public String toString() {
			return age + " " + name + "\n";
		}
	}

}
