import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[][] matrix;
	static int[][] result;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        matrix = new int[N][M];
        result = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                matrix[i][j] = line.charAt(j)-'0';
            }
        }

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                result[i][j] = line.charAt(j)-'0';
            }
        }
        
        if(N < 3 || M < 3) {
        	if (isSame()) {
        		System.out.println(0);
        	} else {
        		System.out.println(-1);
        	}
        	return;
        }
        
        int count = 0;
        
        for (int i = 0; i < N - 2; i++) {
        	for (int j = 0; j < M - 2; j++) {
        		if(matrix[i][j] != result[i][j]) {
        			convert(i, j);
        			count++;
        		}
        	}
        }
        
        System.out.println(isSame() ? count : -1);
    }
    
    public static boolean isSame() {
    	for (int i = 0; i < N; i++) {
    		for (int j = 0; j < M; j++) {
    			if(matrix[i][j] != result[i][j]) {
    				return false;
    			}
    		}
    	}
    	return true;
    }

    public static void convert(int x, int y) {
    	for (int i = x; i < x + 3; i++) {
    		for (int j = y; j < y + 3; j++) {
    			if (matrix[i][j] == 0) matrix[i][j] = 1;
    			else matrix[i][j] = 0;
    		}
    	}
    }

}
