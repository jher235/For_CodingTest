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
	
	static int w,h,x,y,p,ans;
	
	static void check_link(int player_x,int player_y) {
		double left_distance = Math.sqrt(Math.pow(player_x-x,2)+Math.pow(player_y-(y+h/2), 2));
		double right_distance = Math.sqrt(Math.pow(player_x-(x+w),2)+Math.pow(player_y-(y+h/2), 2));
		if(left_distance<=(h/2)||right_distance<=h/2||(x<=player_x&&player_x<=w+x&&y<=player_y&&player_y<=h+y)) {
			ans++;
		}
	}
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		w= sc.nextInt();
		h= sc.nextInt();
		x= sc.nextInt();
		y = sc.nextInt();
		p = sc.nextInt();
		for(int i=0;i<p;i++) {
			int player_x=sc.nextInt();
			int player_y=sc.nextInt();
			check_link(player_x,player_y);
		}
		
		System.out.print(ans);
		
	}
}