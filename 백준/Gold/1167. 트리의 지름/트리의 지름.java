import java.io.*;
import java.util.*;

public class Main {


    static int n;

    static int ans = 0;

    static int endNode;

    static List<Edge>[] tree;

    static boolean[] visited;

    public static class Edge{
        int end;
        int cost;

        public Edge(int end, int cost){
            this.end = end;
            this.cost = cost;
        }
    }

    // 핵심은 아무 노드를 기준으로 가장 먼 거리에 있는 노드가 최대 거리 중 하나의 정점이라는 것.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(stringTokenizer.nextToken());


        tree = new LinkedList[n+1];
        visited = new boolean[n+1];
        for (int i=1;i<=n;i++){
            tree[i] = new LinkedList<>();
        }

        for (int i=0;i<n;i++){
            stringTokenizer = new StringTokenizer(br.readLine()," ");
            int node = Integer.parseInt(stringTokenizer.nextToken());
            int endPoint =  Integer.parseInt(stringTokenizer.nextToken());
            while (endPoint != -1){
                int cost = Integer.parseInt(stringTokenizer.nextToken());
                tree[node].add(new Edge(endPoint, cost));
                endPoint =  Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        dfs(1, 0);
        visited = new boolean[n+1];
        dfs(endNode, 0);

        System.out.println(ans);

    }

    public static void dfs(int node, int cost){
        visited[node] = true;
        boolean move = false;

        for (Edge edge : tree[node]){
            if(!visited[edge.end]){
                dfs(edge.end, cost + edge.cost);
                move = true;
            }
        }
        if (!move){
            if(ans < cost){
                ans = cost;
                endNode = node;
            }
        }
    }

}