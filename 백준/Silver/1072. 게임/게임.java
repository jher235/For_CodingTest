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
	
	static int x,y,c;
	static long z1,z2;
	
	public static void binary(long min,long max ) {
		long middle=(max+min)/2;
		long x2,y2;
		long z3;
		x2=x+middle;
		y2=y+middle;
		z3=(y2*100)/x2;
//		System.out.println(z1+","+z2+","+z3+","+min+","+middle+","+y2+","+x2);
		if(z3>=z2) {
			//System.out.println(min+","+middle+","+z3);
			if(min+1!=max) {
				binary(min,middle);
			}
			else {
				max=min+1;
				System.out.print(max);
			}
			
		}else if(z3<z2) {
	
			//System.out.println(max+","+middle+","+z3);
			if(min+1!=max) {
				binary(middle,max);
			}else {
				max=min+1;
				System.out.print(max);
			}
		}
		
		
	}
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		x = sc.nextInt();
		y=sc.nextInt();
		z1=(long)y*100/x;
		z2=z1+1;
		if(z1>=99) {
			System.out.print(-1);
			return;
		}else {
			binary(0,x+1);
//			System.out.println(c);
//			System.out.print(z1+","+z2);
		}
		
	}
}