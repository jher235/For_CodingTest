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
	static long w,h,f,c,x1,x2,y1,y2;
	static long ans;
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		w = sc.nextInt();
		h = sc.nextInt();
		f = sc.nextInt();
		c = sc.nextInt();
		x1 = sc.nextInt();
		y1 = sc.nextInt();
		x2 = sc.nextInt();
		y2 = sc.nextInt();
	}
	
	public static void main(String args[]){
		input();
		ans = w*h;
		
		long we =f>w-f? f:w-f;
		long hi = h/(c+1);
		
		x2 = x2<we ? x2:we;
		y2 = y2<hi ? y2:hi;
	
		
		long m1 = c+1;
		long m2 = 2*(c+1);
		
		long doublex = f<w-f ? f:w-f;
		long time=0;
		long onetime = x2-x1;
		if(doublex>=x1 && doublex<=x2) {
			time = doublex-x1;
			onetime -=time;
		}else if(doublex>=x2) {
			onetime=0;
			time=x2-x1;
		}
//		System.out.println(doublex +","+time+","+onetime+","+x1);
		ans-=time*(y2-y1)*m2;
		ans-=onetime*(y2-y1)*m1;
		
		System.out.print(ans);
		
	}	
}