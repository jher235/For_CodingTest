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






//dfs구현 - 배열에 연결되는 값을 저장후 큐를 사용해서 순회하면서 분리. 

public class Main{
	static int[][] arr;
	static boolean[] check;
	static int k;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.valueOf(br.readLine());
		
		
		
		for(int q =0;q<t;q++) {
			String[] nm =br.readLine().split(" "); 
			int n = Integer.valueOf(nm[0]);
			int m = Integer.valueOf(nm[1]);
			k = Integer.valueOf(nm[2]);
			
			
		arr = new int[n+1][m+1];
		
		
		
			
			
			for(int i =0;i<k;i++) {
				String[] xy =br.readLine().split(" "); 
				int x= Integer.valueOf(xy[0]);
				int y = Integer.valueOf(xy[1]);
				arr[x][y] = 1;
				
			}
			

			
			

			find();	
			


			
				
				bw.write(String.valueOf(k));
				bw.newLine();
		}
			
			
		
		
	
		
		bw.flush();
		
		br.close();
		bw.close();
	}
	


	
	public static void find() {
		
			for(int i=0;i<arr.length;i++) {
				for(int j=0;j<arr[0].length;j++) {
					if(arr[i][j]==1) {
						Xfind(i,j);
						Yfind(i,j);
						
					}
				}
			}
		
		
	}
	
	public static void Xfind(int y,int x) {//가로를 찾기
		
		arr[y][x]=0;
		if(x>0) {
			
			if(arr[y][x-1]==1) {
				
				k--;
				Yfind(y,x-1);
				Xfind(y,x-1);
			}
			
		}
		if(x<arr[0].length-1) {
			if(arr[y][x+1]==1) {
				
				k--;
				Yfind(y,x+1);
				Xfind(y,x+1);
			}
			
		}
	}
	
	public static void Yfind(int y,int x) {
		arr[y][x]=0;
		if(y>0) {
			
			if(arr[y-1][x]==1) {
				
				k--;
				Yfind(y-1,x);
				Xfind(y-1,x);
			}
			
		}
		if(y<arr.length-1) {
			if(arr[y+1][x]==1) {
			
				k--;
				Yfind(y+1,x);
				Xfind(y+1,x);
			}
			
		}
	}
	
	
}