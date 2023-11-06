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
	static int n,m;
	static int[] know,check;
	static int[][] same; 
//	static Queue<Integer> q = new Queue(); 
	
	static void bps(int x) {
		check[x]=1;
		know[x]=1;
		
		for(int i=0;i<same[x].length;i++) {
			if(check[i]!=1&&same[x][i]==1) {
			
				bps(i);
			}
		}
		
//		for(int cs: same[x]){
//			if(check[cs]!=1&&same[x]) {
//				System.out.println(cs);
//				bps(cs);
//			}
//		}
	}
	
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		
		
		n=sc.nextInt();
		m=sc.nextInt();
		know = new int[n+1];
		check = new int[n+1];
		
		same = new int[n+1][n+1];
		
		int ans=m;
		
		int [][] party = new int[m][]; 
		int k = sc.nextInt();
		
		for(int i=0;i<k;i++) {
			int kn = sc.nextInt();
			know[kn]=1;
		}
		
		for(int i=0;i<m;i++) {
			int people = sc.nextInt();
//			ArrayList<Integer>[] al = new ArrayList<Integer>[];
			int telltrue = 0;
			party[i]= new int[people];
//			same[i] = new int[people];
			for(int j=0;j<people;j++) {
				int p=sc.nextInt();
				party[i][j]=p;
			}

				for(int knowp:party[i]) {
					for(int knowp2:party[i]) {
						same[knowp][knowp2]=1;						
					}	
				}
		}
		
		
		for(int i=1;i<=n;i++) {
			if(know[i]==1 && check[i]==0)
				bps(i);
		}
		for(int i=0;i<m;i++) {			
			for(int as :party[i]) {
//				System.out.print(ans);
				if(know[as] == 1) {
					ans--;
					break;
				}
			}
		}
//		for(int i=1;i<=n;i++)
//		System.out.println(i+":"+know[i]);
		System.out.print(ans);
	}	
}