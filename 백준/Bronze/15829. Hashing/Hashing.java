import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int L = Integer.parseInt(br.readLine());
		BigInteger hash = new BigInteger("0");
		BigInteger mod = new BigInteger("1234567891");
		BigInteger r = new BigInteger("31");
		String str = br.readLine();
		for (int i = 0; i < L; i++) {
			BigInteger ch;
			ch = BigInteger.valueOf(str.charAt(i)-96);
			hash = hash.add(ch.multiply(r.pow(i)).mod(mod));
		}
		hash = hash.mod(mod);
		System.out.println(hash);
		
	}

}
