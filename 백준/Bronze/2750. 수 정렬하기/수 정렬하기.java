
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Arrays;


public class Main{
	public static void main(String args[])  {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] list = new int[n];
		
		for(int i =0 ; i<n; i++) {
			list[i] = sc.nextInt();
		}
	
		Arrays.sort(list);
		for(int i =0 ; i<n; i++) {
			System.out.println(list[i]);
		}
	
	}
}



