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
		int[] stack = {64,32,16,8,4,2,1};
		int c = 0;
		
		while(n!=0) {
			for(int i=0; i<7;i++) {
				if(n >= stack[i]) {
					n -= stack[i];
					c++;
					break;
					
				}
			}
		}
		
		System.out.print(c);
		
		

	}		
	
}