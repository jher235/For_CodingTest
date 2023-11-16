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
	
	static int n;
	static Set<Integer> card;
	
	public static void main(String args[])throws IOException{
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	//	n=sc.nextInt();
		n=Integer.valueOf(br.readLine());
		//sc.nextLine();
		card = new HashSet<Integer>(n);
		String[] slist = br.readLine().trim().split(" ");
		
		for(int i=0;i<n;i++) {
			card.add(Integer.valueOf(slist[i]));			
		}
		//int m=sc.nextInt();
		int m=Integer.valueOf(br.readLine());
		//sc.nextLine();
		String[] checklist =br.readLine().trim().split(" ");
		
		for(int i=0;i<m;i++) {
			
			if(card.contains(Integer.valueOf(checklist[i]))) {
				System.out.print("1 ");
				
			}else {
				System.out.print("0 ");
			}
		} 
		
		br.close();
	}
}
