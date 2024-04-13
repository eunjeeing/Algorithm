import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		HashSet<String> set = new HashSet<>();
 		for(int i = 0; i < N; i++) {
 			String str = br.readLine();
			set.add(str);
		}
 		
        List<String> list = new ArrayList<>(set);
        Collections.sort(list, new StringComparator());
        
        for (String s : list) {
            sb.append(s + "\n");
        }
        System.out.println(sb);
	}

}

class StringComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
    	if(s1.length() > s2.length()) return 1;
    	else if (s1.length() < s2.length()) return -1;
    	else return s1.compareTo(s2);
    }
}