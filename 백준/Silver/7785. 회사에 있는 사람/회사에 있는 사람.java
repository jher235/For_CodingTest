
import java.util.Scanner;
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
	static boolean[] ch;
	static int[][] root;
	static int n,m, ans;
	static ArrayList<String> people;
	static HashMap<String, String> hm;
	
			
	

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String sn = br.readLine();
		int n = Integer.valueOf(sn);
		hm = new HashMap<String, String>();
		
		for(int i=0;i<n;i++) {
			String[] s = br.readLine().split(" ");  
			if(s[1].equals("enter")) {
				hm.put(s[0],"enter");
			}
			else {
				hm.remove(s[0]);
				
			}
		}
		people = new ArrayList<String>();
		int k=0;
		for(String key : hm.keySet()) {
			people.add(k, key);
			k++;
		}
		
	
		
		
		
		
		Collections.sort(people, Collections.reverseOrder());
	
		for(int i=0;i<people.size();i++) {
			System.out.print(people.get(i)+" ");
		}
		
		
		
	}
	
	
	
	
}