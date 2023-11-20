//import java.util.Scanner;
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Arrays;
//import java.util.Comparator;
import java.util.*;
import java.math.*;

//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.math.BigInteger;
//import java.io.IOException;

//import java.nio.Buffer;
//import java.sql.Array;

public class Main{
	static int[] x = {-1,0,1,0,1,1,-1,-1};
	static int[] y = {0,-1,0,1,-1,1,-1,1};
	static int wid,hig,ans;
	static int[][] mt;
	static int[][] check;
	static int[][] check2;
	
	static void circuit(){
		for(int i=0;i<hig;i++) {
			for(int j=0;j<wid;j++) {
				if(check[i][j]==0 && mt[i][j]>0) {
					check2=new int[hig][wid];
					if(dfs(i,j)==1) {
						ans++;
						check[i][j]=1;
					}
				}
			}
		}
	}
	
//	static void dfs(int h,int w) {
//		check[h][w]=1;
//		int count =0;
//		for(int i=0;i<8;i++) {
//			if(h+y[i]>=0 && h+y[i]<hig && w+x[i]>=0 && w+x[i]<wid) {
////				if(mt[h][w] >=mt[h+y[i]][w+x[i]] && check[h+y[i]][w+x[i]]!=1) {
//				if(mt[h][w] >=mt[h+y[i]][w+x[i]] ) {
//					count++;
//				}//else if(check[h+y[i]][w+x[i]]==1) count++;
//				if(check[h+y[i]][w+x[i]]!=1 && mt[h+y[i]][w+x[i]]!=0) {
//					dfs(h+y[i],w+x[i]);
//				}
//			}else count++;
//			
//		}
//		if (count==8) {
//			ans++;
//			check2[h][w]=1;
//		}
//	}
	
	
	static int dfs(int h,int w) {
		check2[h][w]=1;
		int count =0;
		for(int i=0;i<8;i++) {
			if(h+y[i]>=0 && h+y[i]<hig && w+x[i]>=0 && w+x[i]<wid) {
				
				if(mt[h][w] < mt[h+y[i]][w+x[i]] ) {
					return -1;
				}else if(mt[h][w] == mt[h+y[i]][w+x[i]]&& check2[h+y[i]][w+x[i]]!=1) {
					if(dfs(h+y[i],w+x[i])!=1) 
						return -1;
					if(check[h+y[i]][w+x[i]]==1) {
						check[h][w]=1;
						return -1;
					}
				}
////				if(mt[h][w] >=mt[h+y[i]][w+x[i]] && check[h+y[i]][w+x[i]]!=1) {
//				if(mt[h][w] >=mt[h+y[i]][w+x[i]] ) {
//					count++;
//				}//else if(check[h+y[i]][w+x[i]]==1) count++;
//				if(check[h+y[i]][w+x[i]]!=1 && mt[h+y[i]][w+x[i]]!=0) {
//					dfs(h+y[i],w+x[i]);
//				}
			}
			
		}
		
		return 1;
	}
	
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		hig = sc.nextInt();
		wid = sc.nextInt();
		mt = new int [hig][wid];
		check = new int [hig][wid];
		//check2 = new int[hig][wid];
		for(int i=0;i<hig;i++) {
			for(int j=0;j<wid;j++) {
				mt[i][j]=sc.nextInt();
			}
		}
		circuit();
		System.out.println(ans);
		
//		for(int i=0;i<hig;i++) {
//			for(int j=0;j<wid;j++) {
//				System.out.print(check[i][j]);
//			}System.out.println();
//		}
	}
}