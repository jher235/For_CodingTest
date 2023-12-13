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
	
	
	
	public static void main(String args[]) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ans=0;
		String s = br.readLine();
		String s2 = br.readLine();
		
		int[] fir = new int[26];
		int[] sec = new int[26];
		
		for(int i=0;i<s.length();i++) {
			fir[s.charAt(i) - 'a']++;
		}
		for(int i=0;i<s2.length();i++) {
			sec[s2.charAt(i) - 'a']++;
		}
		for(int i=0;i<26;i++) {
			ans += Math.abs(fir[i]-sec[i]);
		}
		System.out.print(ans);
		
	}
	
}
