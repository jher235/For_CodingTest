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
	
	static int n,ans;
	
	static void count(int n) {
		if(n>99) {
			ans=99;
			for(int i=101; i<=n;i++) {
				int first = i/100;
				int second = (i%100)/10;
				int third = i%10;
				if(first-second == second-third) {
					ans++;
				}
			}
		}else {
			ans=n;
		}
	}
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		
		count(n);
		
		
		System.out.print(ans);
		
	}
}