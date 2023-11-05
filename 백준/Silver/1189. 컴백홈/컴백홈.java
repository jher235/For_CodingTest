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
	static String[][] li;
	static int[][] check;
	static int ans,count;
	static int r,c,k;
	
//	static void dps(int x, int y) {
//		System.out.println(x+",,"+y);
//		check[x][y]=1;
//		count++;
//		if(x==0&&y==c-1) {
//			if(count==k) ans++;
//			return;
//		}
//		if(x<(r-1)&&check[x+1][y]!=1) {
//			int temp=count;
//			int[][] save = check;
//			dps(x+1,y);
//			check=save;
//			count=temp;
//		}
//		if(x>0&&check[x-1][y]!=1) {
//			int temp=count;
//			int[][]save = check;
//			dps(x-1,y);
//			check=save;
//			count=temp;
//		}
//		if(y<(c-1)&&check[x][y+1]!=1) {
//			int temp=count;
//			int[][]save = check;
//			dps(x,y+1);
//			check=save;
//			count=temp;
//		}
//		if(y>0&&check[x][y-1]!=1) {
//			int temp=count;
//			int[][]save = check;
//			dps(x,y-1);
//			check=save;
//			count=temp;
//		}
//	
//	}
	
//	static void dps(int x, int y, int[][]ch, int ct) {
//		System.out.println(x+",,"+y);
//		ch[x][y]=1;
//		ct++;
//		if(x==0&&y==c-1) {
//			if(ct==k) ans++;
//			return;
//		}
//		if(x<(r-1)&&ch[x+1][y]!=1) {
////			int temp=count;
////			int[][] save = ch;
//			dps(x+1,y,ch,ct);
////			check=save;
////			count=temp;
//		}
//		if(x>0&&ch[x-1][y]!=1) {
////			int temp=count;
////			int[][]save = check;
//			dps(x-1,y,ch,ct);
////			check=save;
////			count=temp;
//		}
//		if(y<(c-1)&&ch[x][y+1]!=1) {
////			int temp=count;
////			int[][]save = check;
//			dps(x,y+1,ch,ct);
////			check=save;
////			count=temp;
//		}
//		if(y>0&&ch[x][y-1]!=1) {
////			int temp=count;
////			int[][]save = check;
//			dps(x,y-1,ch,ct);
////			check=save;
////			count=temp;
//		}
//	
//	}
	
	static void dps(int x, int y, int[][]ch, int ct) {
		int[][] copy = new int[r][c];//배열이 참조를 사용하지 않도록 아에 새로 만들어 줘야함!!!
		for(int i=0; i<r; i++){
			for(int j=0; j<c; j++){
				copy[i][j] = ch[i][j];
			}
		}
		copy[x][y]=1;
		ct++;
		if(x==0&&y==c-1) {
			if(ct==k) ans++;
			return;
		}
		if(x<(r-1)&&copy[x+1][y]!=1) {
			dps(x+1,y,copy,ct);
		}
		if(x>0&&copy[x-1][y]!=1) {
			dps(x-1,y,copy,ct);
		}
		if(y<(c-1)&&copy[x][y+1]!=1) {
			dps(x,y+1,copy,ct);
		}
		if(y>0&&copy[x][y-1]!=1) {
			dps(x,y-1,copy,ct);
		}
	}
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		k = sc.nextInt();
		sc.nextLine();
		
		String[] sli = new String[c];
		li = new String[r][c];
		check = new int[r][c];
//		save = new int[r][c];
		
		for(int i=0;i<r;i++) {
			String line = sc.nextLine();
			li[i] = line.split("");
			for(int j=0;j<c;j++) {

					if(li[i][j].equals("T")) {
						check[i][j]=1;
					}	
			}
		}
		

		dps(r-1,0,check,0);
		System.out.print(ans);
	}	
}