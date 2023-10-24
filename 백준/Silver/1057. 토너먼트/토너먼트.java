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
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c =1;
		
		if(a>b) {
			int temp;
			temp =a;
			a = b;
			b = temp;
		}
		
		while(!(a%2!=0 && a+1==b) ) {
			c++;
			if(a==1) {
				a=1;
			}else if(a>2 && a%2!=0) {
				a = (a+1)/2;
			}else a= a/2;
			
			
			
			
//			if(b==3) {
//				b=2;
//			}else if(b>2 && b%2!=0) {
//				b = (b+1)/2;
//			}else b=b/2;
			
			if(b>2 && b%2!=0) {
				b = (b+1)/2;
			}else b=b/2;
		}
		
	
		System.out.println(c);
				
				
	}		
	
}