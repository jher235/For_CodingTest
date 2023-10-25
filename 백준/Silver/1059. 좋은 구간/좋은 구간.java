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

	
	public static void main(String args[]) {
		Scanner  sc = new Scanner(System.in);
		
		int s = sc.nextInt();
		int[] num= new int[s];
//		int[] small = new int[s];
//		int[]big= new int[s];
		ArrayList sm = new ArrayList(s);
		ArrayList bg = new ArrayList(s);
		
		for(int i=0; i<s;i++) {
			num[i] = sc.nextInt();
		}
		
		int n = sc.nextInt();
		int bn=1000,sn=0;
		
		for(int i=0; i<s;i++) {
			if(n>num[i]) {
				if(sn<num[i]) sn=num[i];
			}else {
				if(bn>num[i]) {
					bn = num[i];
				}
			}
		}
//		System.out.println(bn);
//		System.out.println(sn);
		if(bn==n||sn==n)
			System.out.print(0);
		else {
			int ans=bn-1-n;
			int n_sn = n-sn-1;
			int bn_sn = bn-n;
			for(int i=0;i<n_sn;i++) {
				ans+=bn_sn;
			}
			
			System.out.print(ans);
		}	
				
	}		
	
}