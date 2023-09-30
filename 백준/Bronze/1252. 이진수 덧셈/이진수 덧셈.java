
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
	static int[] list; 
	static Stack<Integer> sn1,sn2;
	//static String[] sn1, sn2;
	static String ans[];
	
	static void sum(){
		int over =0;
		
		for(int i=0;i<ans.length;i++) {
			int s1=0, s2=0;
			if(!sn1.isEmpty()) {
				s1 = sn1.pop();
			}
			if(!sn2.isEmpty()) {
				s2 = sn2.pop();
			}
			int ssum = over+s1+s2;
			if(ssum==0) {
				ans[i]="0";
				over=0;
			}
			else if(ssum==1) {
				ans[i]="1";
				over=0;
			}
			else if(ssum==2) {
				ans[i]="0";
				over=1;
			}
			else {
				ans[i]="1";
				over=1;
			}
		}
		
		
		
		
	}
	

	public static void main(String args[]) {
			Scanner sc = new Scanner(System.in);

	        String[] snum  = new String[2];
	        snum[0] = sc.next();
	        snum[1] = sc.next();
	        
	        sn1 = new Stack<>();
	        sn2 = new Stack<>();

	        for (String s : snum[0].split("")) {
	            sn1.push(Integer.valueOf(s));
	        }
	        for (String s : snum[1].split("")) {
	            sn2.push(Integer.valueOf(s));
	        }

	        ans = new String[Math.max(sn1.size(), sn2.size()) + 1];
	        sum();
	        
	        
	        
	        int check =0;
	        for (int i = ans.length - 1; i >= 0; i--) {
	            if(check==1 || ans[i]=="1") {
	            	System.out.print(ans[i]);
	            	check=1;
	            }
	        	if(i==0 && check==0) {
	        		System.out.print("0");
	        	}
	        }
	        
		
	}
	
	
	
	
}