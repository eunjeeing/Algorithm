import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        sb.append((1<<N) -1).append("\n");
        recur(1, 3, N);

        System.out.println(sb);
    }

    /* a: 현재 원반이 있는 기둥
       b: 원반을 옮길 목표 기둥
       n: 옮길 원반의 수
     */
    static void recur(int a, int b, int n) {
        if (n == 1) {
            sb.append(a + " " + b).append("\n");
            return;
        }

        recur(a, 6-a-b, n-1);
        sb.append(a + " " + b).append("\n");
        recur(6-a-b, b, n-1);
    }
}
