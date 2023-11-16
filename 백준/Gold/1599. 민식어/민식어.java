//import java.util.Scanner;
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Arrays;
//import java.util.Comparator;
import java.util.*;
import java.math.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.io.IOException;

import java.nio.Buffer;
import java.sql.Array;

public class Main{
	
	static int n;
	
	static ArrayList<String> sarr; 
	static HashMap<String, String> hm = new HashMap<String, String>(20) ;
	static HashMap<String, String> strhm;
	
	public static void settinghm(){
		hm.put("a","a");
		hm.put("b", "b");
		hm.put("k", "c");
		hm.put("d", "d");
		hm.put("e", "e");
		hm.put("g", "f");
		hm.put("h", "g");
		hm.put("i", "h");
		hm.put("l", "i");
		hm.put("m", "j");
		hm.put("n", "k");
		//hm.put("ng", "l");
		hm.put("o", "m");
		hm.put("p", "n");
		hm.put("r", "o");
		hm.put("s", "p");
		hm.put("t", "q");
		hm.put("u", "r");
		hm.put("w", "s");
		hm.put("y", "t");
	}
	
	public static String chg(String s) {
		String chgs = hm.get(s);
		
		return chgs;
	}
	

	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		 n = sc.nextInt();
		 sc.nextLine();
		 sarr = new ArrayList(n);
		 settinghm();
		 strhm = new HashMap<String, String>(n);
		 
		 for(int i=0;i<n;i++) {
			 String sorigin = sc.nextLine();
			// System.out.println(sorigin);
			 String[] s = sorigin.split("");
			 
			 for(int j=0;j<s.length;j++) {
				 if(s[j].equals("n") && j+1<s.length && s[j+1].equals("g")) {
					 s[j]="l";
					 s[j+1]="";
//					 chgs+="l";
					
					 j++;
				 }else {
					s[j]=chg(s[j]);
//					 chgs+=chg(s[j]);
				
				 }

			 }
			 String chgs=String.join("", s);
			 strhm.put(chgs,sorigin);
			// System.out.println(chgs);
			 sarr.add(chgs);
		 }
		Collections.sort(sarr);
		
		 for(String s : sarr) {
			System.out.println(strhm.get(s));
		 }
		 
		 
	}
}
