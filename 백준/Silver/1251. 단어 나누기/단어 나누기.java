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
		
		String ans[] = new String[2];
		String word =sc.nextLine();
		//ans[0] = word;
		
		String s[] = word.split("");
		
		StringBuffer sb = new StringBuffer(word);
		sb.reverse();
		
		//System.out.println( sb.substring(4));
		
		for(int i=1;i<s.length-1;i++) {
			
			for(int j=i+1;j<s.length;j++) {
				
					//ans[1] = sb.substring(j+1)+sb.substring(i+1,j+1)+sb.substring(0,i+1);
					
					ans[1] = sb.substring(j)+sb.substring(i,j)+sb.substring(0,i);
					if(i==1&&j==i+1) ans[0]=ans[1];
					//System.out.println(ans[1]+", "+j+","+i);
					Arrays.sort(ans);		
			}
		}
		
		System.out.print(ans[0]);
	

	}
	
}
