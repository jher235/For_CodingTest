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
	static int c;
	static ArrayList list;
	static int[] arr = {9,8,7,6,5,4,3,2,1,0};
	
	
	
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		list = new ArrayList<Integer>(1023);
		
		dfs(0,0);
		
		
		list.sort(null);
		
		try {
			System.out.print(list.get(n-1));
		}catch(Exception e){
			System.out.print(-1);
		}
		
		
		
		//9876543210
		
				
	}	
	
	static void dfs(long n, int index) {
		if(!list.contains(n)) {
			list.add(n);
		}
		
		if(index>=10) {
			return;
		}
		
		dfs(n*10+arr[index],index+1);
		dfs(n,index+1);
		
		
	}
	
}