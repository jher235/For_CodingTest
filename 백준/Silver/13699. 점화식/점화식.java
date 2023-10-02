
import java.util.Scanner;

import javax.management.Query;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.*;


 

public class Main{
	static int n;
	static long[] t ;
	

	public static void main(String args[]) {
			Scanner sc = new Scanner(System.in);
			n = sc.nextInt();
			t = new long[40];
			t[0] = 1;
			t[1] = 1;
			
			for(int i=2;i<=n;i++) {
				long sum=0;
				int j=0;
				int ii = i-1;
				while(j<ii) {
					sum+= t[j]*t[ii];
					j++;
					ii--;
				}
				
				if(i%2==0)
					sum *=2;
				else {
					sum *=2;
					sum += t[i/2]*t[i/2];
				}
			
				t[i]=sum;
					
			}		
			System.out.print(t[n]);
	}		
}
	