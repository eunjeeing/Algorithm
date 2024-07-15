import java.util.*;
import java.io.*;

public class Main {

    static TreeMap<String, String> map = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 각 문자열 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String word = st.nextToken();
            String mean = st.nextToken();
            map.put(word, mean);
        }

        // 프로그램이 답해야 하는 문자열 입력받기
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            solution(str);
        }
    }

    public static void solution(String str) {
        StringBuilder sb = new StringBuilder();
        boolean found = false;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            for (String key : map.keySet()) {
                if (ch == key.charAt(0)) {
                    if (i + key.length() <= str.length() && str.substring(i, i + key.length()).equals(key)) {
                        found = true;
                        sb.append(map.get(key));
                    }
                }
            }
        }

        System.out.println(found ? sb.toString() : "-1");
    }
}
