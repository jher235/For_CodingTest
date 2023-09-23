
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
	static int[] num, dp;
	static int ans;
	public static void doDp(int i) {
		int j = i-1;
		int value=0;
		while(j>0) {
			
			if(num[i]>num[j]) {
				value = (value>dp[j]?value:dp[j]);
			}
			dp[i] = value+1;
			j--;
		}
		ans = (dp[i]>ans ? dp[i]:ans);
		

	}
	
	
	
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String sn = br.readLine();
		int n = Integer.valueOf(sn);
		num = new int[n+1];
		dp = new int[n+1];
		String[] snum = br.readLine().split(" ");
		for(int i=1;i<n+1;i++) {
			 num[i] = Integer.valueOf(snum[i-1]);
		}
		ans=1;
		dp[0]=0;
		dp[1]=1;
		for(int i=2;i<n+1;i++) {
			doDp(i);
		}
		
		System.out.println(ans);


	}
	
	

	
}
	