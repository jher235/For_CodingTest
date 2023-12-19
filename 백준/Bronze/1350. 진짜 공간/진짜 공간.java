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
	static long ans;

	
	public static void main(String args[]) throws IOException{
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int[] file = new int[n];
		
		for(int i=0;i<n;i++) {
			int f = sc.nextInt();
			file[i] = f;
		}
		int c = sc.nextInt();
		
		for(int i=0;i<n;i++) {
			if(file[i]==0) continue;
			ans+= 1+(file[i]-1)/c;
		}
		
		
			
		System.out.print(ans*c);
		
		
	
		
	}
	
}