
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


 

public class Main{
	static boolean[] dp;
	static int n;
	static void stone(int i) {
		
		if(i<=3) {
			dp[i] = !dp[i-1];
		}
		else {
			if(dp[i-3]==false || dp[i-1]==false)
				dp[i]=true;
		}
			
	}
	
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		dp = new boolean[n+1];
		dp[1] = false;
		for(int i=2;i<=n;i++) {
			stone(i);
		}
		
		if(dp[n]==false)
			System.out.print("SK");
		else 
			System.out.print("CY");
		
		

	}
	
	

	
}