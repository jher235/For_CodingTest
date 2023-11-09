//import java.util.Scanner;
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Arrays;
//import java.util.Comparator;
import java.util.*;
import java.math.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.io.IOException;

import java.nio.Buffer;
import java.sql.Array;

public class Main{
	static int[][] list;
	static int[] check;
	static int n,c;
	
	static int dfs(int k) {
		check= new int[n];
	
		for(int i=0;i<n;i++) {
			if(list[k][i]==1 ) {
				check[i]=1;
				dfs2(i);
			}
		}
		
		check[k]=0;
		if(list[k][k]==0) check[k]=0;
//		for(int i=0;i<n;i++) {
//			System.out.print(check[i]);
//		}System.out.println();
		
		
		c=0;
		for(int i=0; i<n;i++) {
			if(check[i]==1) 
				c++;
		}
		
		
		return c;
		
	}
	static void dfs2(int k) {
		for(int i=0;i<n;i++) {
			if(list[k][i]==1 && check[i]!=1) {
				check[i]=1;
			}
		}
	}
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sc.nextLine();
		list = new int[n][n];
		int min=0;
		
		for(int i=0;i<n;i++) {
			String[] s = sc.nextLine().split("");
			for(int j=0;j<n;j++) {
				if(s[j].equals("Y"))
					list[i][j]=1;
				else list[i][j]=0;
			}
		}
		

		
		for(int i=0;i<n;i++) {
			int d = dfs(i);
			
			min = min>d?min:d;
		}
		
		System.out.print(min);
	}	
}