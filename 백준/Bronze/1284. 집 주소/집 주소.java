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

	static Map m;
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		String[] s = sc.next().split("");
		while(!s[0].equals("0")) {
			int c = 1;
			for(int i=0;i<s.length;i++) {
				c++;
				if(s[i].equals("1")) {
					c+=2;
				}
				else if(s[i].equals("0")) c+=4;
				else c+=3;
			}
			System.out.println(c);
			
			s = sc.next().split("");
		}

	}		
	
}