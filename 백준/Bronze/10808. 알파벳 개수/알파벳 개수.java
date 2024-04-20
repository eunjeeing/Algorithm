import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] alphabet = new int[26];
        String S = br.readLine();
        br.close();
        for (int i = 0; i < S.length(); i++) {
        	alphabet[(int) S.charAt(i)-97]++;
        }
        for(int i : alphabet) {
        	sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

	
}
