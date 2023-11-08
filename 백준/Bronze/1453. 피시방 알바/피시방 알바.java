import java.util.*;
import java.math.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.io.IOException;

import java.nio.Buffer;
import java.sql.Array;



public class Main{

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int ans=0;
		int n = sc.nextInt();
		int[] list = new int[101]; 
		for(int i=0;i<n;i++) {
			int guest = sc.nextInt();
			if(list[guest]!=1) {
				list[guest]=1;
			}else ans++;
		}
		System.out.print(ans);
	}	
}