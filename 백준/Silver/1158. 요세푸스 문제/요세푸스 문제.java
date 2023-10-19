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

	static HashMap<Integer, Integer> hm; 
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int n=  sc.nextInt();
		int k = sc.nextInt();
		
		
	
		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int i=1;i<=n;i++) {
			q.add(i);
		}
		
		System.out.print("<");
		while(q.size()!=1) {
			for(int i=0;i<k-1;i++) {
				q.add(q.poll());
			}
			System.out.print(q.poll()+", ");
		}
		System.out.print(q.poll()+">");
		
		
				
				
	}		
	
}