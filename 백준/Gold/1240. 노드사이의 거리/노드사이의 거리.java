//import java.util.Scanner;
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Arrays;
//import java.util.Comparator;
import java.util.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.io.IOException;

import java.nio.Buffer;




public class Main{
	static node[] tree;
	static int ans; 
	static int[] li;
	static int end=0;
	static class node{
		HashMap<Integer,Integer> neigh = new HashMap<Integer,Integer>();
		
		int ord;
		
		void add(int nd, int len) {
			neigh.put(nd, len);
		}
		
		node(int ord){
			this.ord = ord;
		}
		void find(int nd) {
			//System.out.println(this.neigh.keySet());
			
			if(neigh.containsKey(nd)) {
				end=1;
				ans+=neigh.get(nd);
				System.out.println(ans);
			
			}else {
				//li[nd]=1;
				
				for(int i:neigh.keySet()) {
					//System.out.println(i+"&"+ans);
					if(li[i]!=1&&end==0) {
						li[this.ord]=1;
						int save = ans;
						ans+=neigh.get(i);
						li[i]=1;
						tree[i].find(nd);
						ans=save;
					}
					
				}
				
			}
		}
		
		
		
//		int find(int nd, int pre) {
//			//System.out.println(this.neigh.keySet());
//			if(neigh.containsKey(nd)) {
//				//end=1;
//				ans+=neigh.get(nd);
//				return 0; 
//			}else {
//				
//				int rt=0;
//				
//				for(int i:neigh.keySet()) {
//					if(i!=pre) {
//						ans+=neigh.get(i);
//						rt = i;
//						break;
//					}
//				}
//				return rt;
//			}
//		}
	}
	
	
//	int find(int nd, int pre) {
//		if(neigh.containsKey(nd)) {
//			//end=1;
//			ans+=neigh.get(nd);
//			return 0; 
//		}else {
//			if(neigh.containsKey(pre)) {					
//				neigh.remove(pre);
//			}
//			int rt=0;
//			System.out.println(neigh.keySet());
//			for(int i:neigh.keySet()) {
//				ans+=neigh.get(i);
//				rt = i;
//				break;
//			}
//			return rt;
//		}
//	}
	
	
	public static void main(String args[]) throws IOException {
		Scanner  sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		tree = new node[n+1]; 
//		Main mainInstance = new Main();
//		Main.node[] tree = new Main.node[n+1];
		for(int i = 1; i <= n; i++) {
		    tree[i] = new node(i);
			//tree[i] = mainInstance.new node();
		}

		
		for(int i=0; i<n-1;i++) {
			int nd = sc.nextInt();
			int nd2 = sc.nextInt();
			int len = sc.nextInt();
			
			tree[nd].add(nd2, len);
			tree[nd2].add(nd, len);
			
		}
		
		for(int i=0; i<m;i++) {
			li = new int[n+1];
			int nd = sc.nextInt();
			int nd2 = sc.nextInt();
			
			
//			while(end!=0) {
//				//System.out.println(end);
//				int temp=end;
//				end = tree[end].find(nd2,pre);
//				pre=temp;
//			}
			
			tree[nd].find(nd2);
			
			//System.out.println(ans);
			ans=0;
			end=0;
			
		}
		
				
	}		
	
}
	