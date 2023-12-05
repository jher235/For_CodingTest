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
	
	
	static int n,m;
	static int[] box,book;
	static int ans;
	
	
	public static void main(String args[]) throws IOException{
		Scanner cs = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		n = Integer.valueOf(nm[0]);
		m = Integer.valueOf(nm[1]);
		
		
		String[] boxlist = br.readLine().split(" ");
		String[] booklist = br.readLine().split(" ");
		
		for(int i=0;i<n;i++) {
			ans+=Integer.valueOf(boxlist[i]);
		}
		for(int i=0;i<m;i++) {
			ans-=Integer.valueOf(booklist[i]);
		}
				
		System.out.print(ans);

		
	}
	
}