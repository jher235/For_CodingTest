//import java.util.Scanner;
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Arrays;
//import java.util.Comparator;
import java.util.*;
import java.math.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.io.IOException;

import java.nio.Buffer;
import java.sql.Array;

public class Main{
	static ArrayList<Boolean> artos;
	static int ans;
	
	static void check(int k) {
//		int num = k;
		int count=0;
		int num=2;
		while(k!=1) {
			if(k%num==0) {
				k=k/num;
				count++;
			}else {
				num++;
			}
		}
		if(artos.get(count)) {
			ans++;
		}
		
	}
	
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		artos =  new ArrayList<Boolean>(101);
		artos.add(0,false);
		artos.add(1,false);
		for(int i=2;i<=100;i++) {
			artos.add(i,true);
		}
		
		for(int i=2;(i*i)<=100;i++) {
			if(artos.get(i)) {
				for(int j=i*i;j<=100;j+=i) {
					artos.set(j, false);
				}
			}
		}
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		for(int i = a;i<=b;i++) {
			check(i);
		}
		System.out.print(ans);
		
	}	
}