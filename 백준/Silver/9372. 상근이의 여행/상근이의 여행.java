import java.util.Scanner;
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
	static boolean[] ch;
	static int[][] root;
	static int n,m, ans;
	
	static Queue<Integer> arr;
	static Stack<Integer> st;
			
	

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		
		
		for(int t=0; t<k; t++) {
			n = sc.nextInt();
			root = new int[n+1][n+1];
			ch = new boolean[n+1];
			m = sc.nextInt();
			
			
			
			for(int i=0;i<m;i++) {
				int num1 = sc.nextInt();
				int num2 = sc.nextInt();
				root[num1][num2] = root[num2][num1] = 1;
				
			}
			
			
			System.out.println(n-1);
			
		}

	}
	
	
	
	
}
	