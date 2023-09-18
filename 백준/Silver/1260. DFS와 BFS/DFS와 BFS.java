
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
	
	static int[][] arr;
	static boolean[] check;
	static BufferedWriter bw;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		
		String[] s = br.readLine().split(" ");
		int n = Integer.valueOf(s[0]);
		int m = Integer.valueOf(s[1]);
		int v = Integer.valueOf(s[2]);
		
		arr = new int[n+1][n+1];
		check = new boolean[n+1];
		
		for(int i=0;i<m;i++) {
			
			String[] snum = br.readLine().split(" ");
			int num1 = Integer.valueOf(snum[0]); ;
			int num2 =  Integer.valueOf(snum[1]);;
			
			arr[num1][num2] = arr[num2][num1] = 1;
			
		}
		
		
		dfs(v);
		bw.flush();
		
		check = new boolean[n+1];
		bw.newLine();
		bw.flush();
		
		bfs(v);
		
		
		br.close();
		
		
		bw.flush();
		bw.close();
		
		
	
	}
	
	public static void dfs(int start) throws IOException {
		if(!check[start]) {
			check[start] = true;
			//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			bw.write(start+" ");
			
			for(int i=1; i<arr.length;i++) {
				if(!check[i] && arr[start][i]==1)
					dfs(i);
			}
			
		}
		
		
		
	}
	
	public static void bfs(int start)throws IOException {
		Queue<Integer> q = new LinkedList<Integer>();
		
		
		
		q.offer(start);
		while(!q.isEmpty()) {
			int n = q.poll();
			if (!check[n]) {
				check[n] = true;
				
				bw.write(n+" ");
				
				
				
//				bw.write(q+"->");
//				bw.flush();
				for(int i=1;i<arr.length;i++) {
					if(arr[n][i] == 1 && !check[i]) {
						q.add(i);
						
					}
				}
				
				
			}
		
			
		}
		
		
	}
	
}