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
	
	static int n,m,max,ans;
	static int[] color;

	public static void binary_search(int start, int end) {
		
		int mid = (start+end)/2;
		int sum =0;
		for(int i=0;i<m;i++) {
			sum+=color[i]/mid;
			if(color[i]%mid!=0) sum++;
		}
		if(sum>n) {
			start = mid+1;
		}else {
			ans=mid;
			end=mid-1;
		}
		
		if(start<=end) {
			binary_search(start,end);
			
		}else System.out.print(ans);
	}
	
	public static void main(String args[]) throws IOException{
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		color = new int[m];
		for(int i=0;i<m;i++) {
			color[i]=sc.nextInt();
			max = max>color[i]?max:color[i];
		}
		binary_search(1,max);
					
	}
	
}
