

import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;


public class Main{
	public static void main(String args[])throws IOException  {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(bf.readLine());
	
		int[] list = new int[n];
		
		
		
		String[] slist = bf.readLine().split(" ");
		for(int i=0; i<n; i++) {
			list[i] = Integer.parseInt(slist[i]);
			
		}
		int answer = list[0];
		
		
		for(int i=1;i<n;i++) {
			list[i] = Math.max(list[i-1]+list[i],list[i]) ;
			
			answer = Math.max(answer, list[i]);
		}
		
	
		bw.write(String.valueOf(answer));
		bw.flush();
		
		bf.close();
		bw.close();
	
		
	
	}
}
