//import java.util.Scanner;
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Arrays;
//import java.util.Comparator;
import java.util.*;
import java.math.*;

//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.math.BigInteger;
//import java.io.IOException;

//import java.nio.Buffer;
//import java.sql.Array;

public class Main{
	static int n,r,c,max, pre;
	static long ans;
	static void div4(int f_y,int f_x,int e_y,int e_x ) {
		//System.out.println(f_y+","+f_x+","+e_y+","+e_x+","+ans);
		if(f_y+2==e_y && f_x+2==e_x ) {
			if(r<e_y && c<e_x) {
				ans-=3;
			}else if(r==e_y && c<e_x) {
				ans--;
			}else if(r<e_y && c==e_x) {
				ans-=2;
			}
			
			return;
		}
		
		int midy = (f_y+e_y)/2;
		int midx = (f_x+e_x)/2;
		
		if(r<=midy && c<=midx) {
//			ans+=pre;
//			ans/=4;
			
			ans = pre+((ans-pre))/4;
			div4(f_y, f_x,midy,midx);
		}else if(r<=midy && c<=e_x) {
//			ans+=pre;
//			ans/=2;
			long mid = ans-pre;
			
			ans = pre+ ((mid))/2;
			pre+=(mid)/4;
			
			div4(f_y,midx,midy,e_x);
		}else if(r<=e_y && c<=midx) {
			
//			ans/=4;
//			ans*=3;
			long mid = ans-pre;
			
			ans = pre +((mid)*3)/4;
			pre+=(mid)/2;
			
			div4(midy,f_x,e_y,midx);
		}else {
			
			pre+=((ans-pre)*3)/4;
			
			div4(midy,midx,e_y,e_x);
		}
		
	}
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		r = sc.nextInt()+1;
		c = sc.nextInt()+1;
		
		max = 1<<n;
		ans= max*max;
		div4(0,0,max,max);
		System.out.print(ans-1);
		
	}
}