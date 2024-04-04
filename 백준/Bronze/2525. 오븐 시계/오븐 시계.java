import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) {
		
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        sc.nextLine();
        
        int c = Integer.parseInt(sc.nextLine());
        sc.close();
        
        b += c;
        if(b >= 60) {
        	a += (b/60);
        	b -= (b/60)*60;
        	
        	if(a >= 24) {
        		a -= 24;
        	}
        } 
        
        System.out.println(a + " " + b);
    }
}