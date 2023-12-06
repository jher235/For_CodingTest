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
	
	
	static int d,w,h;
	
	
	private static void find(int w, int h) {
		double w2=Math.pow(w, 2);
		double h2=Math.pow(h,2);

		double ratio = Math.pow(d, 2)/(w2+h2);
		
		w = (int)Math.sqrt(ratio*w2);
		h = (int)Math.sqrt(ratio*h2);
	
			
		System.out.print(w+" "+h);
		
	}
	
	public static void main(String args[]) throws IOException{
		Scanner sc = new Scanner(System.in);
		d = sc.nextInt();
		w = sc.nextInt();
		h = sc.nextInt();
		
		find(w,h);
	
	}
	
}