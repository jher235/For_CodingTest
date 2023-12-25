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
	
	static int[] list;
	static int max;
	
	public static void main(String args[]) throws IOException{
		
		Scanner sc = new Scanner(System.in);
		
		list = new int[10];
		
		String num[] = sc.nextLine().split("");
		
		for(String s:num) {
			int n =Integer.valueOf(s);
			list[n]++;
			
		}
			
		list[6] = (list[6]+list[9]+1)/2;
		
		for(int i=0;i<9;i++) {
			max = max>list[i]?max:list[i];
		}
		
		System.out.print(max);
	}
	
	
}
