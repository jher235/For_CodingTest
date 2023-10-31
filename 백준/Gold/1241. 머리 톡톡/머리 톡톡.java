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
	static long[] num;
	static int c;
	static int[] arr=new int[1000001], list;
	static HashMap<Integer,Integer> hm;
//	static ArrayList<Integer> list;
	
	
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		//list = new ArrayList(); 
		list = new int[n+1];
		//arr = new int[1000001];
		hm = new HashMap();
		
		
		
		
		for(int i=0;i<n;i++) {
			list[i] = sc.nextInt();
			arr[list[i]]++;
		}
//		for(int i=1;i<=n;i++)
//			System.out.println(arr[i]);
		
		for(int i=0;i<n;i++) {
	
			int ans=-1;
			
			
			if(!hm.containsKey(list[i])) {
				if(list[i]!=1)
					ans+=arr[list[i]];
				
				for(int k=1;k<=Math.sqrt(list[i]);k++) {
						if(list[i]%k==0 ) {							
							ans += arr[k];
							if( list[i]/k>Math.sqrt(list[i])&&k!=1) {
								ans += arr[list[i]/k];
								//System.out.println("th:" +list[i]/k);
							}
						}
				}	
				hm.put(list[i],ans);
				
				
			}
			
			System.out.println(hm.get(list[i]));

		}
		
	}	
	
}