//import java.util.Scanner;
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Arrays;
//import java.util.Comparator;
import java.util.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.io.IOException;

import java.nio.Buffer;




public class Main{
	static long[] num;
	
	public static void main(String args[]) throws IOException {
		Scanner  sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] coin = new int[n]; 
		num = new long[10001]; 
		int max=0, min=0;
		for(int i=0;i<n;i++) {
			coin[i] = sc.nextInt();
			//max = max>coin[i] ? max:coin[i];
	
			
		}
	
		num[0]=1;
		
		 
		for(int i:coin) {
			for(int j=1;j<=k;j++) {
				if(j>=i)
				num[j]+= num[j-i];
			}
			
		}
		
			
		
		
		
	System.out.print(num[k]);
		
		
				
	}		
	
}