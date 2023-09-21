
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;






//Bfs구현 

public class Main{
	
	public static void main(String args[]) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		int m = sc.nextInt();
		int n = sc.nextInt();
		
		
		for(int i=m; i<=n;i++) {
			
			int j;
			for( j =2; j<(int)Math.sqrt(i);j++) {
				if(i%j==0)
					break;
			}
			if(i%j!=0 && i!=1)
				System.out.println(i);
			if(i==2)
				System.out.println(i);
		}
		
		
		


	}
	
	

	
}
	
	