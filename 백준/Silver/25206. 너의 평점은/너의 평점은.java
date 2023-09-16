
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
		
		int alltime=0;
		double allgrade = 0;
		for(int i = 0; i<20;i++) {
			String[] str = br.readLine().split(" ");
			if(!str[2].equals("P")) {
				double grade=0;
				if(str[2].equals("A+"))
					grade= 4.5;
				else if(str[2].equals("A0"))
					grade= 4.0;
				else if(str[2].equals("B+"))
					grade= 3.5;
				else if(str[2].equals("B0"))
					grade= 3.0;
				else if(str[2].equals("C+"))
					grade= 2.5;
				else if(str[2].equals("C0"))
					grade= 2.0;
				else if(str[2].equals("D+"))
					grade= 1.5;
				else if(str[2].equals("D0"))
					grade= 1.0;
				else if(str[2].equals("F"))
					grade= 0.0;
				
				//System.out.println(str[2]+"."+grade);
				
				allgrade += grade * Double.parseDouble(str[1]);
				alltime +=Double.valueOf(str[1]);
			}
			
		}
		
//		bw.write(String.valueOf(allgrade));
//		bw.newLine();
//		bw.write(String.valueOf(alltime));
//		bw.newLine();
		bw.write(String.valueOf(allgrade/alltime));
	
		
		bw.flush();
		
		br.close();
		bw.close();
	}
	


	
	
}