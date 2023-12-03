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
	
	static HashSet<String> as;
	static HashMap<String, Integer> first;
	
	public static void main(String args[]) throws IOException{
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		//ans = new String[30];
		as =new HashSet<String>(30);
		first = new HashMap<String, Integer>(n);
		sc.nextLine();
		for(int i=0; i<n;i++) {
			String[] s = sc.nextLine().split("");
			if(!first.containsKey(s[0])) {
				first.put(s[0], 1);
			}else if(first.get(s[0])>=4) {
				as.add(s[0]);
			}
			else {
				first.put(s[0],first.get(s[0])+1);
			}
		}
		
		ArrayList<String> ans = new ArrayList<>(as) ;
		Collections.sort(ans);
		for(String s: ans) System.out.print(s);
		if(ans.isEmpty()) System.out.print("PREDAJA");
	}
}