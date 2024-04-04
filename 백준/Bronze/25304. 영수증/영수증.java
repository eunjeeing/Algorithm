import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		int x = sc.nextInt();
		sc.nextLine();
		int n = sc.nextInt();
		
		while (n > 0) {
			sc.nextLine();
			int a = sc.nextInt();
			int b = sc.nextInt();
			sum += a*b;
			n--;
		}
		if(x == sum) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
		
    }
}