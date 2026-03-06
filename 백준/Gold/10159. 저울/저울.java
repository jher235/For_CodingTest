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
    private static int N, M;

    private static List<List<Integer>> lower;
    private static List<List<Integer>> upper;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        lower = new ArrayList<>(N);
        upper = new ArrayList<>(N);

        for (int i=0;i<=N; i++){
            lower.add(new ArrayList<>());
            upper.add(new ArrayList<>());
        }

        for (int i=0;i<M; i++){
            StringTokenizer sb = new StringTokenizer(br.readLine());
            int bigger = Integer.parseInt(sb.nextToken());
            int smaller = Integer.parseInt(sb.nextToken());

            lower.get(bigger).add(smaller);
            upper.get(smaller).add(bigger);
        }

        StringBuilder sb = new StringBuilder();

        for (int i=1; i<=N; i++){
            Set<Integer> lowVisited = new HashSet<>();
            lowDfs(i, lowVisited);
            Set<Integer> upVisited = new HashSet<>();
            upDfs(i, upVisited);

            int related = lowVisited.size() + upVisited.size();

            sb.append( (N-1) - related).append("\n");
        }

        System.out.println(sb);
    }

    private static void lowDfs(int node, Set<Integer> visited){
        List<Integer> low = lower.get(node);

        for (Integer l : low){
            if(!visited.contains(l)){
                lowDfs(l, visited);
            }
        }
        visited.addAll(low);
    }

    private static void upDfs(int node, Set<Integer> visited){
        List<Integer> up = upper.get(node);
        for (Integer u : up){
            if(!visited.contains(u)){
                upDfs(u, visited);
            }
        }
        visited.addAll(up);
    }

}
