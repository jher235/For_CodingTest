import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;


public class Main{
	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(bf.readLine());
		
		int[] list = new int[n+1];
		list[0] = 0;
		list[1] = 0;
		
		
		for (int i = 2; i<n+1; i++) {
			
			int ans = 1+list[i-1];
			
			if(i%2==0 && i%3 ==0) {
				list[i] = 1+ Math.min(list[i/2], list[i/3]);
			}
			else if(i%2==0) {
				list[i] = 1 + list[i/2];
			}
			else if(i%3==0) {
				list[i] = 1+list[i/3];
			}
			if (list[i] !=0)
				list[i] = Math.min(ans, list[i]);
			else 
				list[i] = ans;
		}
	
		
		int ans = list[n];
		bw.write(String.valueOf(ans));
		bw.flush();
		
		bf.close();
		bw.close();
		
	}
}