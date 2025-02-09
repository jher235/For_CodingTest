import java.io.*;
import java.util.*;


public class Main {

    public static int N, M;

    public static ArrayList<Integer>[] list;
    public static Queue<NodeData> queue = new LinkedList<>();
    public static boolean[] visited;
    public static int ansDepth = 0;
    public static int ansNode = 0;
    public static int count = 0;

    public static class NodeData {
        int node;
        int depth;

        public NodeData(int node, int depth){
            this.node = node;
            this.depth = depth;
        }
    }

    // 깊이를 알 수 있는 bfs를 사용
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        visited = new boolean[N+1];
        list = new ArrayList[N+1];
        for (int i=0;i<=N;i++){
            list[i] = new ArrayList<>();
        }

        for (int i=0;i<M;i++){
            stringTokenizer = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());
            list[start].add(end); // 양방향
            list[end].add(start);
        }

        queue.add(new NodeData(1,0));
        visited[1] = true;

        while (!queue.isEmpty()){
            NodeData nodeData = queue.poll();
            int currentNode = nodeData.node;
            int currentDepth = nodeData.depth;
            if(ansDepth < currentDepth){
                ansDepth = currentDepth;
                count = 1;
                ansNode = currentNode;
            }else if(ansDepth == currentDepth){
                count++;
                if(ansNode > currentNode) ansNode = currentNode;
            }
            bfs(currentNode, currentDepth);
        }

        System.out.println(ansNode+" "+ansDepth+" "+count);
    }

    private static void bfs(int node, int depth){

        for (int next : list[node]){
            if(!visited[next]){
                visited[next] = true;
                queue.add(new NodeData(next, depth+1));
            }
        }

    }

}