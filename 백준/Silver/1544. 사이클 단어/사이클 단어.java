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
	static int n;
	static int[] arr;
	static int[][] dp;
	
	static ArrayList<String> starr;
	
	
	
	public static void main(String args[]) throws IOException{
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());
		int  count=0;
		n = Integer.valueOf(br.readLine());
		starr = new ArrayList<String>(2500);
		
		for(int i=0;i<n;i++) {
			String s = br.readLine();
			if(!starr.contains(s)) {
				count++;
				for(int j=0;j<s.length();j++) {
					String s_case=s.substring(j)+s.substring(0,j);
					starr.add(s_case);
				}
			}
			
			
		}
		br.close();
		
		System.out.print(count);
	}
}