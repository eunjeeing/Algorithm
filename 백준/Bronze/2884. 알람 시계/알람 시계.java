import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);
        
        int h = sc.nextInt();
        int m = sc.nextInt();
        sc.close();
        
        m -= 45;
        if(m < 0) {
        	h -= 1;
        	m += 60;
        	
        	if (h == -1) {
        		h = 23;
        	}
        }
        System.out.println(h + " " + m);

    }
}