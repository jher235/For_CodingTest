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
import java.io.StreamTokenizer;
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
	static long[][] sqr; 	
	static int max,min;

	
	private static void check() {
		long[] cha = new long[6];
		int k=0;
		for(int i=0;i<4;i++) {
			for(int j=i+1;j<4;j++) {
				cha[k] = (sqr[i][0]-sqr[j][0])*(sqr[i][0]-sqr[j][0]) +(sqr[i][1]-sqr[j][1])*(sqr[i][1]-sqr[j][1]);
				k++;
			}
		}
		Arrays.sort(cha);
		if(cha[0]==cha[1]&&cha[2]==cha[1]&&cha[2]==cha[3]&&cha[5]==cha[4]) {
			System.out.println(1);
		}else System.out.println(0);
			
		
	}
	

	
	public static void main(String args[]) throws IOException{
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		for(int i=0;i<n;i++) {
			
			sqr = new long[4][2];
			for(int j=0;j<4;j++) {
				int x,y;
				x= sc.nextInt();
				y = sc.nextInt();
				sqr[j][0] = x;
				sqr[j][1] = y;
			}
			
			check();
		}
	
		
	}
	
}