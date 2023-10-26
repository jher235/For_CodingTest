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

	
	public static void main(String args[]) throws IOException {
		Scanner  sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> num = new ArrayList();
		String sn[] = br.readLine().split(""); 
		
		for(String s : sn)
		num.add(Integer.valueOf(s));
		
		Collections.sort(num,Collections.reverseOrder());
		for(int i : num)
		System.out.print(i);
				
	}		
	
}
	