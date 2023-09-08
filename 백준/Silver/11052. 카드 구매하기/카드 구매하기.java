import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;


public class Main{
	public static void main(String args[])throws IOException  {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		
		int n = Integer.valueOf(bf.readLine());
		
		int answer = 0;
		
		int[] list = new int[n+1];
		String[] slist = bf.readLine().split(" ");
		
		int[] rest = new int[n+1];
		int[] ans = new int[n+1];

		for(int i=1; i<n+1; i++) {
			list[i] = Integer.parseInt(slist[i-1]);
			
		}
		
		
		ans[1] = list[1]*n;
		rest[1] = list[1];
		
		for(int i=2; i<n+1; i++) {
			rest[i] = Math.max(list[i],rest[i-1]+list[1]);
			for(int j=i; j>=(i+1)/2; j--)
				rest[i] = Math.max(rest[i],rest[j]+rest[i-j] );
			
//			System.out.println(i+"="+rest[i]);
		}
		
//		for(int i=2; i<n+1; i++) {
//			
//			ans[i]= list[i]*(n/i)+rest[n%i];
//			ans[i] = Math.max(ans[i-1],ans[i]) ;//세번째 카드를 살때 현재 구매하는 방법이거나 2번재 +1번째를 비교
//			System.out.println(ans[i]);
//		}
		
		
		
		//카드가 1개만 있을 때 가장 비싼 값, 2개 구매할 때 가장 비싼 값... -> 이걸 저장하며 동적 계산하기
		
		
		
		
		
		bw.write(String.valueOf(rest[n]));
		bw.flush();
		
		bf.close();
		bw.close();
	
		
	
	}
}