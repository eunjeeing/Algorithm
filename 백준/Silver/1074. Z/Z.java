import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int count = solution(N, r, c);
        System.out.println(count);
    }

    public static int solution(int N, int r, int c) {
        if (N == 0) {
            return 0;
        }

        int half = (int) Math.pow(2, N-1);

        if (r < half && c < half) {
            // 1사분면
            return solution(N-1, r, c);
        } else if (r < half && c >= half) {
            // 2사분면
            return half * half + solution(N-1, r, c-half);
        } else if (r >= half && c < half) {
            // 3사분면
            return 2 * half * half + solution(N-1, r-half, c);
        } else {
            // 4사분면
            return 3 * half * half + solution(N-1, r-half, c-half);
        }

    }

}
