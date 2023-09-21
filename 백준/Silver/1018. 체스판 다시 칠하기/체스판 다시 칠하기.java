
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;






//Bfs구현 

public class Main{
	static String[][] ch;
	static int x,y;
	
	static String[][] blist;
	static String[][] wlist;
	static int count=100;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] size = br.readLine().split(" ");
		
		x = Integer.valueOf(size[0]);
		y = Integer.valueOf(size[1]);
		
		ch = new String[x][y];
		for(int i=0; i<x;i++) {
			String[] line = br.readLine().split("");
			for(int j=0; j<y; j++) {
				ch[i][j] = line[j];
			}
		}
		
		
		blist = new String[x][y];
		wlist = new String[x][y];
		
		for(int i=0; i<8;i+=2) {
			for(int j=0; j<8; j+=2) {
				wlist[i][j]="B";
				wlist[i][j+1]="W";
			}
		}
		for(int i=1; i<8;i+=2) {
			for(int j=0; j<8; j+=2) {
				wlist[i][j]="W";
				wlist[i][j+1]="B";
			}
		}
		
		
		for(int i=1; i<8;i+=2) {
			for(int j=0; j<8; j+=2) {
				blist[i][j]="B";
				if(j+1<8)
				blist[i][j+1]="W";
			}
		}
		for(int i=0; i<8;i+=2) {
			for(int j=0; j<8; j+=2) {
				blist[i][j]="W";
				if(j+1<8)
					blist[i][j+1]="B";
			}
		}
		
		
		for(int i=0; i<x-7;i++) {
			for(int j=0;j<y-7;j++) {
				
					int ans1 = Bstart(i,j);
					int ans2 = Wstart(i,j);
					int ans = (ans1 > ans2) ? ans2 : ans1;
					count = count > ans ? ans : count ;
				
				
			}
		}
		
		
		
		

			
		
		bw.write(String.valueOf(count));
	
		
		bw.flush();
		
		br.close();
		bw.close();
	}
	
	
public static int Bstart(int a, int b){
	int ct = 0;
	
	
	for(int i=0; i<8;i++) {
		for(int j=0; j<8; j++) {
			
			if(!ch[a+i][b+j].equals(blist[i][j]))
				ct++;
		}
		
	}

	return ct;
	
}

public static int Wstart(int a, int b){
	int ct = 0;

	

	for(int i=0; i<8;i++) {
		for(int j=0; j<8; j++) {
			
			if(!ch[a+i][b+j].equals(wlist[i][j]))
				ct++;
		}
		
	}
	
	return ct;
}
	
	
	
	
	
}
