import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;





public class Main{
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		int n =	sc.nextInt();
		int[] list = new int[n];
		int count = 0;
		int max = 0;
		
		for(int i=0; i<n;i++) {
			
			list[i] = sc.nextInt();
			
		}
		
		for(int i=n-1; i>=0; i--) {
			if(list[i]>max) {
				count +=1;
				max = list[i];
			}
		}
		
		System.out.println(count);
	}
}
