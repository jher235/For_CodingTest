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
	static Queue<Integer> q;
	static Deque<Integer> arr;
	
	
	static void move_left() {
		int temp = q.poll();
		q.add(temp);
	}
//	static void move_left() {
//		int temp = arr.pollFirst();
//		arr.addLast(temp);
//	}
//	static void move_right() {
//		int temp = arr.pollLast();
//		arr.addFirst(temp);
//	}
	
	static int find(int k) {
		int count = 0;
		
		while(q.peek()!=k) {
			move_left();
			count++;
		}
		count = count<=q.size()-count ? count : q.size() - count;
		
		q.poll();
		return count;
	}
	
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n=0,m, ans=0;
		n = sc.nextInt();
		m = sc.nextInt();
		q = new LinkedList<Integer>();
//		arr = new ArrayDeque<>();
		for(int i=1;i<=n;i++) {
			q.add(i);
		}
		for(int i=0;i<m;i++) {
			int num =sc.nextInt();
			ans+=find(num);
		}
		
		System.out.print(ans);
	}
}