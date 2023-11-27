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
	static int n,s,m, ans;
	static int[] arr;
	static int[][] dp;
	
	
	
	private static void dfs(int k,int l) {
		//System.out.println(l+"번째"+k+"값");
		if( l+1<=n&& k-arr[l]>=0 ) {
			if(dp[l+1][k-arr[l]]==0) {
				dp[l+1][k-arr[l]]=1;
				dfs(k-arr[l],l+1);
			}
		}
		if( l+1<=n&&  k+arr[l]<=m ) {
			
			if(dp[l+1][k+arr[l]]==0) {
				dp[l+1][k+arr[l]]=1;
				dfs(k+arr[l],l+1);
			}
		}
	}
	

	public static void main(String args[]) throws IOException{
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		s = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		dp = new int[n+1][m+1];
		arr = new int[n];
		ans = m;
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.valueOf(st2.nextToken());
		}
		dp[0][s]=1;
			
		dfs(s,0);
		
		for(int i=m;i>=0;i--) {
			if(dp[n][i]==1) {
				System.out.println(i);
				return;
			}		
		}
		System.out.println("-1");
	}
}