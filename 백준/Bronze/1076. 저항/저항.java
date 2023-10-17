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
//	class led{
//		int value;
//		int mul;
//		
//		led(int a, int b){
//			this.value = a;
//			this.value = b;
//		}
//	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		

//		led black = new led(0,1);
//		led brown = new led(1,10);
//		led red = new led(2,100);
//		led orange= new led(3,1000);
//		led yellow = new led(4,10000);
//		led green = new led(5,100000);
//		led blue = new led(6,1000000);
//		led violet = new led(7,10000000);
//		led grey = new led(8,100000000);
//		led white = new led(9,1000000000);
		
		int[] n = new int[3];
		
	
		for(int i=0; i<3;i++) {
			String sn = sc.next();
			int j=0;
			if(sn.equals("black"))
				j=0;
			if(sn.equals("brown"))
				j=1;
			else if(sn.equals("red"))
				j=2;
			else if(sn.equals("orange"))
				j=3;
			else if(sn.equals("yellow"))
				j=4;
			else if(sn.equals("green"))
				j=5;
			else if(sn.equals("blue"))
				j=6;
			else if(sn.equals("violet"))
				j=7;
			else if(sn.equals("grey"))
				j=8;
			else if(sn.equals("white"))
				j=9;
		
			n[i] = j;
		}
		
		StringBuilder sb =  new StringBuilder();
		
		
		
		for(int i=0; i<n[2];i++) {
			sb.append("0");
		}
		
		String sans = sb.toString();
	
		if(n[0]==0 && n[1]==0 )
			System.out.print(0);
		else if(n[0]==0)
			System.out.print(n[1]+sans);
		else
			System.out.print(n[0]+""+n[1]+sans);
		

	}		
	
}
	