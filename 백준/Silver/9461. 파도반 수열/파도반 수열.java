import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;
import java.io.IOException;
import java.util.Arrays;


public class Main{
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.valueOf(br.readLine());
		
		
		
		int[] arr = new int[n];
		int max = 0;
		
		for(int i=0; i<n;i++) {
			arr[i] = Integer.valueOf(br.readLine());
			if(max<arr[i])
				max = arr[i];
		}
		long[] dp = new long[max+1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 2;
		dp[5] = 2;
		
				
			
		
		for(int i=6; i<max+1;i++) {
			dp[i] = dp[i-1]+dp[i-5];
		}		
				
		for(int i=0; i<n;i++) {
			bw.write(String.valueOf(dp[arr[i]]));
			bw.newLine();
		}
		
		bw.flush();
		
		br.close();
		bw.close();
	}
}
