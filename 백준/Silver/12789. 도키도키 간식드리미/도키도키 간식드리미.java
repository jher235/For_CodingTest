
import java.util.Scanner;

import javax.management.Query;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.*;


 

public class Main{
	static int n;
	static int[] list; 
	static Stack<Integer> arr; 
	static LinkedList<Integer> q;
			
	
	static int check(){
		int squence=1;
		
		while(squence!=n) {
			if(q.isEmpty() && arr.peek()!=squence) {
				return 0;
			}
			
			if(!q.isEmpty() && q.peek()==squence) {
				q.poll();
				squence++;
			}
			else if(!arr.isEmpty() && arr.peek()==squence) {
				arr.pop();
				squence++;
				
			}
			else {
				arr.add(q.poll());
			}
			
			
		}
		
		
		
		return 1;
	}
	

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		q = new LinkedList<Integer>();
		arr = new Stack<Integer>();
		for(int i =0;i<n;i++) {
			int num = sc.nextInt();
			q.add(num);
		}
		
		if(check()==1) {
			System.out.print("Nice");
		}
		else {
			System.out.print("Sad");
		}
			
		
	}
	
	
	
	
}