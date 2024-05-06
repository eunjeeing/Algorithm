import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		sb.append(average(arr)).append("\n");
		sb.append(median(arr)).append("\n");
		sb.append(mode(arr)).append("\n");
		sb.append(range(arr)).append("\n");
		
		System.out.println(sb);
	}
	
	public static int average(int[] arr) {
		double sum = 0.0;
		for(int i : arr) {
			sum += i;
		}
		return (int) Math.round(sum/arr.length);
	}
	
	public static int median(int[] arr) {
		return arr[arr.length/2];
	}
	
	public static int mode(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		if (arr.length == 1) {
            return arr[0];
        }
		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
		}
		int maxValue = Collections.max(map.values());
		
		ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> newMap : map.entrySet()) {
            if (newMap.getValue() == maxValue) {
                list.add(newMap.getKey());
            }
        }
        Collections.sort(list);
        
        if (list.size() > 1) return list.get(1);
        else return list.get(0); 
		
	}
	
	public static int range(int[] arr) {
		int min = arr[0];
		int max = arr[arr.length-1];
		return max - min;
	}
}
