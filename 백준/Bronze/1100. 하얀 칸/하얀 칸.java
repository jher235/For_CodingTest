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
	
	static int n,m,max;
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ans=0;
		for(int i=0;i<4;i++) {
			String[] st= br.readLine().split("");
			String[] st2 = br.readLine().split("");
			for(int j=0;j<8;j+=2) {
				String white = st[j];
				String black = st[j+1];
				if(white.equals("F")) ans++;
				
			}
			for(int j=0;j<8;j+=2) {
				
				String black = st2[j];
				String white = st2[j+1];
				if(white.equals("F")) ans++;
				
			}
		}
		System.out.print(ans);
		
	}
}

