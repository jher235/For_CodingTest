
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;





public class Main{
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.valueOf(br.readLine());
		
		for(int i=0; i<n;i++) {
			String[] snum = br.readLine().split(" ");
			int num1 = Integer.valueOf(snum[0]);
			int num2 = Integer.valueOf(snum[1]);
			bw.write(String.valueOf(num1+num2));
			bw.newLine();
		}
		
		bw.flush();
		
		br.close();
		bw.close();
		
	}
}

