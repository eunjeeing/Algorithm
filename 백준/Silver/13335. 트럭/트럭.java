import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 트럭 수
        int w = Integer.parseInt(st.nextToken()); // 다리 길이
        int L = Integer.parseInt(st.nextToken()); // 다리 최대하중

        Queue<Integer> truck = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            truck.offer(Integer.parseInt(st.nextToken()));
        }

        Queue<Integer> bridge = new LinkedList<>();
        int weight = 0;
        int time = 0;

        for (int i = 0; i < w; i++) {
            bridge.offer(0);
        }

        while(!bridge.isEmpty() || !truck.isEmpty()) {
            time++;
            weight -= bridge.poll();
            if(!truck.isEmpty()) {
                if (weight + truck.peek() <= L) {
                    int temp = truck.poll();
                    bridge.offer(temp);
                    weight += temp;
                } else {
                    bridge.offer(0);
                }
            } 
        }
        System.out.println(time);
    }
}
