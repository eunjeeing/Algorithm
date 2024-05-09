import java.util.*;
import java.io.*;

/*
 * 자주 나오는 단어일수록 앞에 배치한다.
	해당 단어의 길이가 길수록 앞에 배치한다.
	알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치한다
 * 
 */
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		HashMap<String, Integer> map = new HashMap<>();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			String word = br.readLine();
			if(word.length() >= M) map.put(word, map.getOrDefault(word, 0)+1);
		}
		
		List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
		
        Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() != o2.getValue()) {
                	if (o1.getValue() > o2.getValue()) {
                        return -1;
                    } else if (o1.getValue() < o2.getValue()) {
                    	return 1;
                    }
                }
                if (o1.getKey().length() != o2.getKey().length()) {
                	if (o1.getKey().length() > o2.getKey().length()) {
                        return -1;
                    } else if (o1.getKey().length() < o2.getKey().length()) {
                    	return 1;
                    }
                }

                return o1.getKey().compareTo(o2.getKey());
            }
        });
        
        for(Iterator<Map.Entry<String, Integer>> iter = entryList.iterator(); iter.hasNext();){
            Map.Entry<String, Integer> entry = iter.next();
            sb.append(entry.getKey()).append("\n");
        }
        System.out.println(sb);
	}

}
