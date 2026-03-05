import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;


class Main{

    private static int ans;
    private static int N;

    private static boolean[][] map;

    private static PriorityQueue<Len> pq = new PriorityQueue<>((l1, l2) -> l1.value - l2.value);

    private static class Len{
        private int value;
        private int x;
        private int y;

        public Len(int value, int x, int y) {
            this.value = value;
            this.x = x;
            this.y = y;
        }
    }

    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(br.readLine());

        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                if(input[j] == '0'){
                    continue;
                }
                if(input[j] > 'Z'){
                    pq.add(new Len(input[j] - 'a' + 1, i, j));
                }else {
                    pq.add(new Len(input[j] - 'A' + 27, i, j));
                }
            }
        }


        while (!pq.isEmpty()){
            Len cur = pq.poll();
            if(getParent(cur.x) != getParent(cur.y)){
                union(cur.x, cur.y);
            }else{
                ans += cur.value;
            }
        }


        int parent = getParent(0);
        for (int i=0; i<N; i++){
            if(getParent(i) != parent){
                System.out.println(-1);
                return;
            }
        }

        System.out.println(ans);
    }

    private static int getParent(int idx){
        if(parent[idx] == idx){
            return idx;
        }
        return getParent(parent[idx]);
    }

    private static void union(int x, int y){
        x = getParent(x);
        y = getParent(y);

        if(x < y){
            parent[y] = x;
        }else{
            parent[x] = y;
        }
    }
}
