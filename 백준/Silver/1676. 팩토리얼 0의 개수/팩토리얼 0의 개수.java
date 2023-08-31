import java.util.Arrays;
import java.util.Scanner;
import java.math.BigInteger;




public class Main {
	public static void main(String args[]) {
		
//		Scanner scanner = new Scanner(System.in);
//		String input = scanner.nextLine();
//		int num = Integer.parseInt(input);
	
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int result=0;
		BigInteger r = new BigInteger("1");
		for (int i =2; i<=n; i++) {
			
			
			r = r.multiply(BigInteger.valueOf(i));
			while (r.mod(BigInteger.TEN).equals(BigInteger.ZERO)) {
				result += 1;
				r = r.divide(BigInteger.TEN);
			}
				
		}
		System.out.print(result);
		
	}		
}


