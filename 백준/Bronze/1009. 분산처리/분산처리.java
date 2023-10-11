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


	
	public static void main(String args[]) {
		
		Scanner sc= new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int tt=0;tt<t;tt++) {
			 
			int a = sc.nextInt();
			int b = sc.nextInt();
			int[] list = new int[100];
			int i=1;
			list[0]=(a%10==0? 10:a%10);
			
			
			
			
			
				while(true) {
					
					int rest = (a*list[i-1])%10;
					rest = (rest==0 ? 10:rest);
					if(rest==list[0]) break;
					//list[i]=(list[0]*list[i-1])%10;
					
					list[i] = rest;
					//System.out.println(list[i]);
					i++;
					
					
				}
				
				int c = b%i;
				
				if(c>0)System.out.println(list[c-1]);
				else
					System.out.println(list[i-1]);
		
			
		}
		
	}		
	
}
	