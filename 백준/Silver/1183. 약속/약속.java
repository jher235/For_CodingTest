//import java.util.Scanner;
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Arrays;
//import java.util.Comparator;
import java.util.*;
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
	static int[] list;
	static ArrayList<Integer> under;
	static ArrayList<Integer> up;

	
	static void postpone() {

		int count=1;
		if(list.length%2==0) {
			count += list[n/2]-list[n/2-1];
		}
		System.out.print(count);
		
	}
	
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		list = new int[n];

		
		
		for(int i=0;i<n;i++) {
			int promise=sc.nextInt();
			int arrive=sc.nextInt();
			int gap =  arrive-promise;
			list[i]=gap;

		}
		
		Arrays.sort(list);
		
		postpone();		
		
	}
}