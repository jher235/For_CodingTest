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
	static int s,k;

	public static void main(String args[]) throws IOException{
		Scanner sc = new Scanner(System.in);
		s = sc.nextInt();
		k = sc.nextInt();
		int share = s/k;
		int rest = s%k;
		long ans=1;
		ans = (long)Math.pow(share+1, rest);
//		System.out.println(ans);
		ans *= (long)Math.pow(share, k-rest); 
		
		System.out.println(ans);
	}
}