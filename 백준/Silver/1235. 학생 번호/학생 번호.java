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
import java.io.IOException;

import java.nio.Buffer;



public class Main{
	static int[] dp;
	
	

	
	public static void main(String args[])throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine());
		String[][] stu = new String[n+1][10];
		for(int i=0;i<n;i++) {
			String[] slist = br.readLine().split("");
//			for(int j=0;j<slist.length;j++) {
//				stu[i]=slist;
//			}
			stu[i]=slist;
			
		}
		
		String[] st = new String[n];
		for(int i=stu[0].length-1;i>=0;i--) {
			HashSet<String> hm = new HashSet<String>();
			
			for(int j=0;j<n;j++) {
				st[j] = stu[j][i]+st[j];
				
				hm.add(st[j]);
				
			}
			if(hm.size()==n) {
				System.out.print(stu[0].length-i);
				break;
			}
			
		}
		
		
		
		br.close();
		
	}		
	
}