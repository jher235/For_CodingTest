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
	static int[] num;
	
	private static void solution(int l) {
		int start = 0;
		
		while(start+2*l<=num.length) {
			
			int fir=0, sec=0;
			for(int i=0;i<l;i++) {
				fir+=num[start+i];
			}
			for(int i=0;i<l;i++){
				sec+=num[start+l+i];
			}
			if(fir == sec) {
				System.out.print(l*2);
				return;
			}else start++;
			
		}
		solution(l-1);
		
	}
	
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		
		num = new int[s.length()];
		
		for(int i=0;i<s.length();i++) {
			num[i] = Character.getNumericValue(s.charAt(i));
			
		}
		int len = num.length/2;
		
		solution(len);
	
	}
	
}