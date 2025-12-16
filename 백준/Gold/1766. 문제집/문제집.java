import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {

    private static int N;
    private static int M;

    private static ArrayList<Integer>[] relatedProblems;
    private static int[] preProblemCounts;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        relatedProblems = new ArrayList[N+1];

        for (int i = 1; i <= N; i++) {
            relatedProblems[i] = new ArrayList<>();
        }

        preProblemCounts = new int[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int pre = Integer.parseInt(st.nextToken());
            int after = Integer.parseInt(st.nextToken());
            relatedProblems[pre].add(after);
            preProblemCounts[after] += 1;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder ans = new  StringBuilder();

        for (int i = 1; i < N+1; i++) {
            if( preProblemCounts[i] == 0) {
                pq.add(i);
            }
        }

        while (!pq.isEmpty()) {
            Integer cur = pq.poll();
            ans.append(cur).append(" ");
            for (int problem : relatedProblems[cur]){
                if(--preProblemCounts[problem] == 0) {
                    pq.add(problem);
                }
            }
        }

        System.out.println(ans);
    }

}