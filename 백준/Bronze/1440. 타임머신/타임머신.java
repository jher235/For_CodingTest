//import java.util.Scanner;
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Arrays;
//import java.util.Comparator;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.math.*;
import java.sql.Array;

//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.math.BigInteger;
//import java.io.IOException;

//import java.nio.Buffer;
//import java.sql.Array;

public class Main{
	
	
	
	public static void main(String args[]) throws IOException{
		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ans=0;
		String[] s = br.readLine().split(""); 
		int[] time = new int[3];
		time[0] = Integer.valueOf(s[0])*10 + Integer.valueOf(s[1]);
		time[1] = Integer.valueOf(s[3])*10 + Integer.valueOf(s[4]);
		time[2] = Integer.valueOf(s[6])*10 + Integer.valueOf(s[7]);
		
		for(int i=0; i<3;i++) {
			if(time[i]<0 || time[i]>59) {
				System.out.print(ans);
				return;
			}
		}
		for(int i=0; i<3;i++) {
			if(time[i]>0 && time[i]<13) {
				ans+=2;
			}
		}
		System.out.print(ans);
	}
	
}