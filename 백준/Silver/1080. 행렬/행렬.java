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



public class Main{
	static int[][] a,b;
	static int ans;
	
	static void swap(int x,int y) {
		ans++;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(a[x+i][y+j]!=0)a[x+i][y+j]=0;
				else a[x+i][y+j]=1;
			}
		}
		
	}
	
	public static void main(String args[]) throws IOException {
		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nm = br.readLine().split(" ");
		int n =  Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);
		a=new int[n][m];
		b=new int[n][m];
		
		for(int i=0;i<n;i++) {
			String[] s = br.readLine().split("");
			for(int j=0;j<m;j++) {
				a[i][j]=Integer.valueOf(s[j]);
			}
		}
		
		for(int i=0;i<n;i++) {
			String[] s = br.readLine().split("");
			for(int j=0;j<m;j++) {
				b[i][j]=Integer.valueOf(s[j]);
			}
		}
		for(int i=0;i<n-2;i++) {
			for(int j=0;j<m-2;j++)
				if(a[i][j]!=b[i][j]) {
					swap(i,j);
				}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++)
				if(a[i][j]!=b[i][j]) {
					System.out.print(-1);
					return;
				}
		}
		System.out.print(ans);
		br.close();
	
	}	
}