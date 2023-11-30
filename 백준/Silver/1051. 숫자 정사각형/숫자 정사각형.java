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
	
	static int n,m,max;
	static int[][] box;
	
	static private void solution() {
		while(find(max)!=1) {
			max--;
		}
	}
	
	static private int find(int s) {
		for(int i=0;i<n-s;i++) {
			for(int j=0;j<m-s;j++) {
				if(check(i,j,s)==1) {
					return 1;
				}
			}
		}
		return 0;
	}
	
	static private int check(int y,int x,int s) {
		if(box[y][x]==box[y+s][x]&&box[y+s][x]==box[y][x+s]&&box[y][x+s]==box[y+s][x+s]) {
			return 1;
		}
		return 0;
	}
	
	public static void main(String args[]) throws IOException{
		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		//StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(nm[0]);
		m = Integer.parseInt(nm[1]);
		max = n<m?n:m;
		box = new int[n][m];
		
		for(int i=0;i<n;i++) {
			
			String[] st1 = br.readLine().split(""); 
			
			
			for(int j=0;j<m;j++) {
				box[i][j]=Integer.valueOf(st1[j]);
			}
		}
		
		solution();
		
		System.out.print((int)Math.pow(max+1,2));
		
	}
}
