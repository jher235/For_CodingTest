//import java.util.Scanner;
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Arrays;
//import java.util.Comparator;
import java.util.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

import java.nio.Buffer;



public class Main{
	static long n;
	static int l;

	public static void main(String args[])throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] dp = new long[n+1];
		dp[0]=1;
		if(dp.length>1)
			dp[1]=1;
		
		for(int i=2;i<=n;i++) {
			dp[i] = dp[i-1]+dp[i-2]+1;
		}
		
		System.out.print(dp[n]%1000000007);
			
		
		
		
	}		
	
}
	