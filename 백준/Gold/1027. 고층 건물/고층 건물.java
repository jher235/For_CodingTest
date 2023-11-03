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
	static int n, ans;
	static int[] tw,seetw;
	
	static void see(int k) {
		int twn=k+1;
		double slope=((double)(tw[k]-tw[twn]+100)/(twn-k));
		while(twn<n) {
			double sl = ((double)(tw[k]-tw[twn])/(twn-k));
//			if(sl<=0)sl=-sl;
//			System.out.println(k+":"+sl);
			if(slope>sl) {
				seetw[k]++;
				seetw[twn]++;
				slope=sl;
			}
			twn++;
//			else {
//				if(k<n-2)see(++k);
//				break;
//			}
			
		}
		if(k<n-2)see(++k);
		
		//-1,-3,-1,-0.2
		//4,2.5
		//9,4,2.6,
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		tw = new int[n];
		seetw = new int[n];
		int max=0;
		for(int i=0;i<n;i++) {
			tw[i] = sc.nextInt();
		}
		
		if(1<n)see(0);
		
		for(int i=0;i<n;i++) {
			max=max>seetw[i] ? max:seetw[i];
		}
		System.out.print(max);
	
	}	
}