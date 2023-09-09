
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;


public class Main{
	public static void main(String args[])  {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		ArrayList<Integer> ans = new ArrayList<Integer>();
		
		dfs[] d = new dfs[n+1];
		
		for(int i=0; i<n+1;i++) {
			d[i] = new dfs();
		}
		
		int answer = 0;
		
		
		for(int i = 1 ; i<m+1; i++) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			
			d[num1].li.add(num2);
			d[num2].li.add(num1);
				
		}
		
		for(int i =1; i<n+1; i++) {
			LinkedList<Integer> check = new LinkedList<Integer>();
			//for(Integer element: d[i].li)
			
			if(d[i].c ==0) {
				d[i].c =1;
				answer +=1;
				
				for(int j=0; j<d[i].li.size();j++) {
					check.add(d[i].li.get(j));
					d[d[i].li.get(j)].c=1;
					
				}
				while(check.size() !=0) {
					int ch = check.getFirst();
					for(int j =0;j<d[ch].li.size();j++) {
						if (d[d[ch].li.get(j)].c==0) {
							d[d[ch].li.get(j)].c=1;
							check.add(d[ch].li.get(j));
						}
					}	
					check.remove();
				}
			}
			
		}
		
	
		System.out.println(answer);
		
	
	
		
	
	}
}


class dfs{
	ArrayList<Integer> li = new ArrayList<Integer>();
	int c = 0;
}