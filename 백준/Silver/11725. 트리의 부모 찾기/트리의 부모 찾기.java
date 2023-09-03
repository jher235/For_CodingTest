import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;


class Node{
	ArrayList<Integer> list;
	Node(){
		list = new ArrayList<Integer>();
	}
	int parents =0;
	void search(){//입력받으면 서치를 구동시켜서
		
	}
	
}





public class Main{
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		Node[] tree = new Node[n+1];
		int[] ans = new int[n+1];
		
		for(int i=1; i<n+1;i++) {
			tree[i] = new Node();
		}
		
		for(int i=0; i<n-1;i++) {
			
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			tree[num1].list.add(num2);
			tree[num2].list.add(num1);
			
		}
		
		tree[1].parents = 1;
		for(int i=0; i<tree[1].list.size();i++) {
			tree[tree[1].list.get(i)].parents =1;
			queue.addLast(tree[1].list.get(i));
		}
		
		while (queue.size()!=0) {
			int q = queue.getFirst();
			for(int i=0; i<tree[q].list.size();i++) {
				if(tree[tree[q].list.get(i)].parents==0 ) {
					tree[tree[queue.getFirst()].list.get(i)].parents =q;
					queue.addLast(tree[q].list.get(i));
				}
			}
			queue.removeFirst();
		}

		
		for(int i=2;i<n+1;i++ ) {
			System.out.println(tree[i].parents);
		}
		
		
	}
}
