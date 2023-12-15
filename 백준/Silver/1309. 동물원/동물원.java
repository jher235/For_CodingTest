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
	static long[] dp; 	
	
	
	
	public static void main(String args[]) throws IOException{
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		dp = new long[n+3];
		
		dp[0]=1;
		dp[1]=3;
		
		
		for(int i=2;i<=n;i++) {
			dp[i] = (2*dp[i-1]+dp[i-2])%9901;
		}
		
		
		System.out.print(dp[n]);
		
	}
	
}