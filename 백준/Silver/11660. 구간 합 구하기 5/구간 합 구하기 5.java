
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
		
		
		String[] nm = br.readLine().split(" ");
		int n = Integer.valueOf(nm[0]);
		
		int m = Integer.valueOf(nm[1]);		
		
		int[][] arr = new int[n+1][n+1];
		int[][] dp = new int[n+1][n+1];
		
//		for(int i=1; i<=n;i++) {
//			for(int j=1; j<=n;j++) {
//				arr[i][j] = Integer.valueOf(br.read());
//				dp[i][j] = dp[i][j-1] + arr[i][j];
//			}
//		}
		
		 for (int i = 1; i <= n; i++) {
	            String[] input = br.readLine().split(" ");
	            for (int j = 0; j < input.length; j++) {
	                arr[i][j+1] = Integer.parseInt(input[j]);
	            }
	        }

	        // dp 배열 초기화
	        for (int i = 1; i <= n; i++) {
	            for (int j = 1; j <= n; j++) {
	                dp[i][j] = dp[i][j - 1] + arr[i][j];
	                //System.out.println("dp["+i+"]"+"["+j+"]"+"="+dp[i][j]);
	            }
	        }

		
	
		
		
		int[] x1= new int[m+1];
		int[] x2 = new int[m+1];
		int[] y1 = new int[m+1];
		int[] y2 = new int[m+1];
		
		for(int i=1; i<m+1;i++) {
			String[] input = br.readLine().split(" ");
			
			x1[i] = Integer.valueOf(input[0]);
			x2[i] = Integer.valueOf(input[2]);
			y1[i] = Integer.valueOf(input[1]);
			y2[i] = Integer.valueOf(input[3]);
			//System.out.println(x2[i]+"and"+y2[i]);
		}
		
		for(int i=1; i<m+1;i++) {
			int ans=0;
				for(int j=x1[i];j<=x2[i];j++) {
					ans += dp[j][y2[i]]-dp[j][y1[i]-1];
					 //System.out.println("dp["+j+"]"+"["+y2[i]+"]"+"="+dp[j][y2[i]]);
					 //System.out.println("dp["+j+"]"+"["+y1[i-1]+"]"+"="+dp[j][y1[i-1]]);
					// System.out.println("ans="+ans);
					 //System.out.println(j+"=j"+i+"번"+ans);
					//System.out.println(dp[j][y2[i]]+"=dp->"+dp[j][y1[i]]+"/"+i+"번"+ans);
				}
			bw.write(String.valueOf(ans));
			
			bw.newLine();
		}
		
		
		
		
		bw.flush();
		
		br.close();
		bw.close();
	}
}