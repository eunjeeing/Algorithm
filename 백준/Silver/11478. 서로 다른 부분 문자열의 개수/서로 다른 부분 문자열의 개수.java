import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		br.close();
		
		HashSet<String> set = new HashSet<>();  
		
        for (int i = 0; i < S.length(); i++) {
            int start_idx = 0;
            int end_idx = i + 1;
            while (end_idx <= S.length()) {
                set.add(S.substring(start_idx, end_idx));
                start_idx++;
                end_idx++;
            }
        }
        
        System.out.println(set.size());
	}

}
