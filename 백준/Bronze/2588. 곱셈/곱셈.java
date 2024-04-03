import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	
	public static void main(String args[]) throws IOException{
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        String b = br.readLine();
        
        for(int i = b.length()-1; i >= 0; i--) {
        	System.out.println(a * (b.charAt(i)-'0'));
        }
    	System.out.println(a * Integer.parseInt(b));
        
    }
}