
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
	static HashMap<Integer,Integer> hm; 
	
	public static void main(String args[])throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.valueOf(br.readLine());
		hm = new HashMap<Integer, Integer>(n);
		String[] sn = br.readLine().split(" ");
		for(int i =0;i<n;i++) {
			int num = Integer.valueOf(sn[i]);
			if(hm.containsKey(num)) {
				int c = hm.get(num);
				hm.put(num, ++c);
			}
			else {
				hm.put(num, 1);
			}
		}
		int m = Integer.valueOf(br.readLine());
		String[] sm = br.readLine().split(" ");
		for(int k=0;k<m;k++) {
			int num = Integer.valueOf(sm[k]);
			if(hm.containsKey(num)) {
				bw.write(String.valueOf(hm.get(num)+" "));
			}
			else {
				bw.write("0 ");
			}
			
		}
		bw.flush();
		br.close();
		bw.close();
		
		
	}		
	
}
	