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
	static int n, m;
	static Map<Integer, Integer> wire;
	static int min1;
	static int min2;
	
	static void find() {
		int ans=0;
		
		while(n!=0) {
			if(n>6) {
				n-=6;
				ans+=min1;
			}
			else {
				
				if(min2*n<min1) {
					ans+=min2*n;
				}else {
					ans+=min1;
				}
				n=0;
			}
		}
		
		System.out.print(ans);
	}
	
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		wire = new HashMap();
		n = sc.nextInt();
		m = sc.nextInt();
		//int[] six = new int[2*m+1];
		ArrayList<Integer> six = new ArrayList<Integer>(2*m+1);
		int[] one = new int[m+1];
		min1=1001;
		min2 = 1001;
		for(int i=0;i<m;i++) {
			int a= sc.nextInt();
			int b= sc.nextInt();
//			six.add(a);
//			six.add(b*6);
//			one[i]=b;	
			min1=min1<a ? min1:a;
			min1=min1<b*6 ? min1:b*6;
			min2=min2<b?min2:b;
		}
		find();
		
	}	
}