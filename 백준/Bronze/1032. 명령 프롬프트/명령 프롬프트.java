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
		
		int n = sc.nextInt();

		m = new HashMap<>(50);
		int sz=0;
		for(int i=0; i<n; i++) {
			String[] str = sc.next().split("");
			sz = str.length;
			
			for(int j=0;j<sz;j++) {

				
				if(i==0)
					m.put(j,str[j]);
				else {
					if(!m.get(j).equals(str[j])) {			
						m.put(j,"?");
					}
				}
	
							
			
			}
		}
		for(int i=0;i<sz;i++)
			System.out.print(m.get(i));
		

	}		
	
}