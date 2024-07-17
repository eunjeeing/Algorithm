import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[] S;
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        S = new int[N];

        // 수열 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 1;
        dfs(0, 0);
        while(true) {
            if (set.contains(answer)) answer++;
            else break;
        }
        System.out.println(answer);
    }

    static void dfs(int idx, int sum) {
        if (idx == N) {
            if (sum > 0) set.add(sum);
        }
        else {
            dfs(idx+1, sum + S[idx]);
            dfs(idx+1, sum);
        }
    }
}
