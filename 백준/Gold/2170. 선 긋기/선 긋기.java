import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] line = new int[N][2];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            line[i][0] = Integer.parseInt(st.nextToken());
            line[i][1] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(line, (o1,o2) -> (o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]));

        int[][] mergeLine = new int[N][2];
        int count = 0;

        int curStart = line[0][0];
        int curEnd = line[0][1];
        for (int i = 1; i < N; i++) {
            int start = line[i][0];
            int end = line[i][1];

            if (start <= curEnd) {
                curEnd = Math.max(curEnd, end);
            } else {
                mergeLine[count][0] = curStart;
                mergeLine[count][1] = curEnd;
                count++;
                curStart = start;
                curEnd = end;
            }
        }

        mergeLine[count][0] = curStart;
        mergeLine[count][1] = curEnd;
        count++;

        int sum = 0;
        for (int i = 0; i < count; i++) {
            sum += mergeLine[i][1] - mergeLine[i][0];
        }

        System.out.println(sum);
    }
}
