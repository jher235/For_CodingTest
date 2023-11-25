//import java.util.Scanner;
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Arrays;
//import java.util.Comparator;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.*;
import java.sql.Array;

//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.math.BigInteger;
//import java.io.IOException;

//import java.nio.Buffer;
//import java.sql.Array;

public class Main{
	static int n, tape;
	static int[] leak;
	static boolean[] check;
	
	private static void work(){
		int count=0,order=0;
		check = new boolean[n];
		
		for(int i=0;i<n;i++) {
			if(!check[i]) {
				taping(i);
				count++;
			}
		}
		System.out.print(count);
	}
	
	private static void taping(int k) {
		check[k]=true;
		int next=k+1;
		while( next<n &&(leak[next]-leak[k])<tape ) {
			check[next]=true;
			next++;
		}
	}
	
	
	public static void main(String args[]) throws IOException{
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		tape = Integer.valueOf(st.nextToken());
		leak = new int[n];
		for(int i=0;i<n;i++) {
			leak[i] = Integer.valueOf(st2.nextToken());
		}
		Arrays.sort(leak);
		work();
	}
}