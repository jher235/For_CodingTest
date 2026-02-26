
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;


class Main{

    private static int[] mx = {0, 0, 1, -1};
    private static int[] my = {1, -1, 0, 0};

    private static int N, L;

    private static int[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        Deque<int[]> deque = new LinkedList<>();

        st = new StringTokenizer(br.readLine());


        StringBuilder sb = new StringBuilder();

        for (int i=0; i<N; i++){
            int input = Integer.parseInt(st.nextToken());


            while (!deque.isEmpty()){
                int[] pre = deque.peekLast();

                if (input <= pre[0] || pre[1] + L <= i){
                    deque.pollLast();
                }else {
                    break;
                }
            }
            deque.add(new int[]{input, i});

            while (true){
                int[] currentMin = deque.peekFirst();

                if(currentMin[1] + L <= i){
                    deque.pollFirst();
                }else {
                    break;
                }
            }

            sb.append(deque.peekFirst()[0]).append(" ");

        }
        System.out.println(sb);

    }

}
