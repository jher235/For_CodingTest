//import java.util.Scanner;
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Arrays;
//import java.util.Comparator;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.math.*;
import java.sql.Array;

//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.math.BigInteger;
//import java.io.IOException;

//import java.nio.Buffer;
//import java.sql.Array;

public class Main{
	static int n;
	static int[] dp; 	
	static int[] arr;
	
	public static void under_3(){
		if(n<2) {
			System.out.print(arr[1]);
		}else if(n<3) {
			System.out.print(arr[2]+arr[1]);
		}
		
	}
	
	private static void solution() {
		dp[0] = 0;
		dp[1] = arr[1];
		dp[2] = arr[1]+arr[2];
		
		for(int i=3;i<=n;i++) {
			
			dp[i] = dp[i-1] > arr[i]+dp[i-2] ? dp[i-1]:arr[i]+dp[i-2];
			dp[i] = arr[i] + arr[i-1] + dp[i-3]>dp[i] ? arr[i] + arr[i-1] + dp[i-3]:dp[i];
		}
		
		System.out.print(dp[n]);
	}
	
	public static void main(String args[]) throws IOException{
		Scanner sc = new Scanner(System.in);
		//점화식 dp [i] = arr[i] + arr[i-1] + dp[i-3] > arr[i]+dp[i-2]> dp[i-1]
		n = sc.nextInt();
		dp = new int[n+3];
		arr = new int[n+1];
		for(int i=1;i<=n;i++) {
			arr[i]= sc.nextInt();
		}
		
		if (n<3) {
			under_3();
			return;
		}
		solution();
		
		
		
	}
	
}