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
	static long n;
	static int l;
	

	
	public static void main(String args[])throws IOException {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int[]p = new int[n+1];
		int[]j = new int[1001];
		int[]carr = new int[1001];
		int[]cnum = new int[1001];
		int[]carr2= new int[n+1];

		int c=0;
		ArrayList<Integer> alp = new ArrayList<Integer>();
		for(int i=0;i<n;i++) {
			int num = sc.nextInt();
			p[i] = num;
			j[num] = i;
			alp.add(num);
		}
		alp.sort(Comparator.naturalOrder());
		int cou=0;
		for(int t:alp) {
			carr[t]++;
			
			cnum[t]=cou;
			cou++;
			//System.out.println(cnum[t]);
		}
		cnum[0]=0;

		for(int i=0;i<n;i++) {
			int num = p[i];
			carr[num]--;
			System.out.print(cnum[num]-carr[num]+" ");
			
		}
		
		
		
	}		
	
}