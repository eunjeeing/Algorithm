import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        long count  = pow(A, B, C);
        System.out.println(count);
    }

    static long pow(long A, long B, long m) {
        if (B == 1) return A % m;
        long val = pow(A, B/2, m);
        val = val * val % m;

        if (B % 2 == 0) return val;

        return val * A % m;
    }
}
