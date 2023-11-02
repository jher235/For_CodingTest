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



public class Main{
	static int[] num;
	static int min;
	static void find() {
		while(true) {
			int ans=0;
			for(int i=0; i<5;i++) {
				if(min%num[i]==0) {
					ans++;
				};
			}
			if(ans>=3) {
				System.out.print(min);
				return ;
			}
			min++;	
		}
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		num = new int[5];
		min=101;
		for(int i=0; i<5;i++) {
			num[i]=sc.nextInt();
			min=min<num[i] ? min:num[i];
		}
		find();
		
	
	}	
}