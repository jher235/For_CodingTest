
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
	static long n;
	static int l;

	
	public static void search(int k){
//		if(n==1000){
//			n=1;
//		}
//		if(((n!=1&&(n/k)<k/2)) || k>100)
//			System.out.print(-1);
		if((n/k)+1<k/2 || k>100)
			System.out.print(-1);
		else {
			if(n%k==0&&k%2!=0) {
			//	System.out.println(1);
			
				for(int i=k/2;i>0;i--) {
					System.out.print((n/k)-i+" ");
				}
				for(int i=0;i<=k/2;i++) {
					System.out.print((n/k)+i+" ");
				}
				
			}
			else if((double)(n%k)/(double)k==0.5&&k%2==0) {
				//System.out.println(2);
				for(int i =1; i<=k;i++) {
					System.out.print((n/k)-(k/2)+i+" ");
				}
			}
			else {
				k++;
				if((n/k)+1>=k/2 && k<101)
					search(k);
				else
					System.out.print(-1);
			}
		}

		
		
	
	}
	 
	
	
	public static void main(String args[])throws IOException {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		l = sc.nextInt();
		
		search(l);
	
	}		
	
}