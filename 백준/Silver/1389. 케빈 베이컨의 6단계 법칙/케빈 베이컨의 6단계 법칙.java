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
	
	static int[][] cevin;
	static int n,m,count;
	static Set<Integer> card;
	static int[] checklist; 
	static peo[] p; 
	static Queue<Integer> q;
	static Queue<Integer> q_suv;
	static class peo{
		ArrayList<Integer> know ;
		
		peo(int n){
			this.know = new ArrayList(n+1);
		}
		void plus(int k){
			this.know.add(k);
		}
	}
	
	static int find(int k){
		int time=1;
		checklist = new int[n+1];
		checklist[k]=1;
		count=0;
		q = new LinkedList<>(); 
		q_suv = new LinkedList<Integer>();
		for(int kk: p[k].know)
			check(kk,time);
		q.addAll(q_suv);
		q_suv.clear();
		//System.out.println(count);
		
		while(!q.isEmpty()) {
			time++;
			for(int q_int:q) {
				check(q_int,time);
			}
			q.clear();
			q.addAll(q_suv);
			q_suv.clear();
		//	System.out.println(count);
		}
		return count;
	}
	
	static void check(int k, int t) {
		
		
			
		if(checklist[k]!=1) {
			count+=t;
			checklist[k]=1;
		}
		for(int a:p[k].know) {
			if(checklist[a]!=1) {		
				q_suv.add(a);
				
			}
		}
	}
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int min=500001;
		int ans=0;
		
		cevin = new int[n+1][n+1];
		p = new peo[n+1];
		for(int i=1;i<n+1;i++) {
			p[i] =new peo(n);
		}
		
		for(int i=0;i<m;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			p[a].plus(b);
			p[b].plus(a);
			
		}
		
		for(int i=1;i<n+1;i++) {
			//System.out.println(find(i));
			 if(find(i)<min) {
				 min=find(i);
				 ans=i;
			 }
		}
		System.out.print(ans);
		
		
	}
}