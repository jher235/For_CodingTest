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
	static int n,ans;
	static String[] word;
	
	
	private static void check(String a, String b) {
		HashMap<String, String> change = new HashMap<String, String>(26);
		HashMap<Character,Character> ch = new HashMap<Character, Character>();  
		for(int i=0;i<a.length();i++) {
			if(ch.containsKey(a.charAt(i)) ) {
				if(ch.get(a.charAt(i))!= b.charAt(i)) return;
				
			}
			else {
				if(ch.containsValue(b.charAt(i))) return;
				else ch.put(a.charAt(i), b.charAt(i));

			}
			
		}
			
		
		ans++;
		//System.out.println(a+", "+b);
	}
	

	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(br.readLine());
		word = new String[n];
		
		for(int i=0;i<n;i++) {
			word[i] = br.readLine(); 
		}
		
		for(int i=0;i<n-1;i++) {
			for(int j=i+1;j<n;j++) {
				check(word[i],word[j]);
			}
		}
		
			
		System.out.print(ans);
		
		
	
		
	}
	
}