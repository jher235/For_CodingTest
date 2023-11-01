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
	static int[] p,s,li,first,li2,goal;
	static int n;
	static int count=0;
	//static Arrays p,s,li,first,li2;
	
	
	static void find(){
		if(Arrays.equals(li,goal)) {
			System.out.print(count);
			return;
		}else {
			li2=li.clone();
			for(int i=0;i<n;i++) {
				
				li[s[i]]=li2[i];
			}
			count++;
		}
		
		
		while (true) {
			if(Arrays.equals(goal, li)) {
				System.out.print(count);
				return;
			}
			else if(Arrays.equals(p,li)) {
				System.out.print(-1);
				return;
			}
			else {
				li2=li.clone();
				for(int i=0;i<n;i++) {
					
					li[s[i]]=li2[i];
				}
				//System.out.println(li);
				count++;
			}
		}
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
	
		n = sc.nextInt();
			
		p = new int[n+1];
		s = new int[n+1];
		li = new int[n+1];
		li2 = new int[n+1];
		first = new int[n+1];
		goal = new int[n+1];
		for(int i=0;i<n;i++) {
			p[i]=sc.nextInt();
			li[i]=p[i];
			//first[i]=li[i];
			goal[i] = i%3;
			
		}
		for(int i=0;i<n;i++) {
			s[i]=sc.nextInt();
			
			
		}

		
		
		find();
		
	
	}	
}