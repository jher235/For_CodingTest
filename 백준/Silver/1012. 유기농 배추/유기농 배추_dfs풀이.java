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






//dfs구현 

public class Main{
	static int[][] arr;
	static boolean[][] check;
	static int n,m,k;
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {1,0,-1,0};
	
	static void dfs(int x, int y) {
		 check[x][y] = true;
		 
		 for(int i=0; i<4;i++) {
			 int cx = x+dx[i];
			 int cy = y+dy[i];
			 
			 if(cx >=0 && cy>=0 && cx<n && cy<m) {
				 if(!check[cx][cy] && arr[cx][cy]==1) {
					 dfs(cx,cy);
				 }
			 }
		 }
 		
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.valueOf(br.readLine());
		
		
		
		for(int q =0;q<t;q++) {
			String[] nm =br.readLine().split(" "); 
			n = Integer.valueOf(nm[0]);
			m = Integer.valueOf(nm[1]);
			k = Integer.valueOf(nm[2]);
			
		int count=0;	
		arr = new int[n][m];
		
		
		check = new boolean[n][m];
			
			
			for(int i =0;i<k;i++) {
				String[] xy =br.readLine().split(" "); 
				int x= Integer.valueOf(xy[0]);
				int y = Integer.valueOf(xy[1]);
				arr[x][y] = 1;
				
			}
			
			for(int i=0;i<arr.length;i++) {
				for(int j=0;j<arr[0].length;j++) {
					if(!check[i][j] && arr[i][j]==1) {
						dfs(i,j);
						count++;
					}
				}
			}
			
			

			


			
				
				bw.write(String.valueOf(count));
				bw.newLine();
		}
			
			
		
		
	
		
		bw.flush();
		
		br.close();
		bw.close();
	}
	


	
	
	
	
	
	
}
