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
		int c = 0;
		
		for(int i=666;i<6660000;i++) {
			
			if(String.valueOf(i).contains("666")) {
				c++;
				if(c==n) {
					System.out.print(i);
					break;
				}
			}
			
			
		}
		
		
	}		
	
}