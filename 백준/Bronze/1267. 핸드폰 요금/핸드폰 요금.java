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
	
	static int n,m,max;
	static int[] call;
	
	public static int ys() {
		int yans=0;
		for(int i=0;i<n;i++) {
			yans+=(1+call[i]/30)*10;
		}
		return yans;
		
	}
	public static int ms() {
		int mans=0;
		for(int i=0;i<n;i++) {
			mans+=(1+call[i]/60)*15;
		}
		return mans;
	}

	public static void main(String args[]) throws IOException{
		Scanner sc = new Scanner(System.in);
		int m,y;
		n=sc.nextInt();
		call = new int[n];
		
		for(int i=0;i<n;i++) {
			call[i] = sc.nextInt();
		}
		m=ms();
		y=ys();
				
		if(y==m) {
			System.out.print("Y M "+y);
		}else if(y>m) {
			System.out.print("M "+m);
		}else {
			System.out.print("Y "+y);
		}
		
		
	}
}