import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[] arr;
    static boolean[] check;
    static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        check = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr[i] = i;
        }

        dfs(0);
        System.out.println(sb);
    }

    static void dfs(int k) {
        if (k == M) {
            for (int i = 0; i < k; i++) {
                sb.append(arr[i]+1 + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!check[i]) {
                check[i] = true;
                arr[k] = i;
                dfs(k+1);
                check[i] = false;
            }
        }
    }
}