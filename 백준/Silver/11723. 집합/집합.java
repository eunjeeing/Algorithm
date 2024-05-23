import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			int num = 0;
			if(st.hasMoreTokens()) num = Integer.parseInt(st.nextToken()); 
			if(cmd.equals("add")) {
				if(list.contains(num)) continue;
				else list.add(num);
			} else if (cmd.equals("remove")){
				if(!list.contains(num)) continue;
				else list.remove(list.indexOf(num));
			} else if (cmd.equals("check")){
				if(list.contains(num)) sb.append(1).append("\n");
				else sb.append(0).append("\n");
			} else if (cmd.equals("toggle")){
				if(list.contains(num)) {
					list.remove(list.indexOf(num)); 
				}
				else list.add(num);
			} else if (cmd.equals("all")){
				list.clear();
				int j = 1;
				while(j <= 20) {
					list.add(j++);
				}
			} else if (cmd.equals("empty")){
				list.clear();
			}
		}
		System.out.println(sb);
	}

}
