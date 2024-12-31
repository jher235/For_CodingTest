import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static PriorityQueue<Node> queue;
    static ArrayList<LinkedList<Node>> graph;

    static int MAX = 987654321;

    static List<Integer> ansList = new LinkedList<>();
    static  Path[] distance;


    static class Node{
        int end;
        int cost;

        Node(int end, int cost){
            this.end = end;
            this.cost = cost;
        }
    }

    static class Path{
        int cost;
        List<Integer> nodes;

        Path(int cost, List<Integer> nodes){
            this.cost = cost;
            this.nodes = nodes;
        }
    }


    // 핵심은 아무 노드를 기준으로 가장 먼 거리에 있는 노드가 최대 거리 중 하나의 정점이라는 것.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(br.readLine());

        graph = new ArrayList<>(n+1);
        distance = new Path[n+1];

        for (int i=0;i<=n;i++){
            graph.add(new LinkedList<>());
            distance[i] = new Path(MAX, new LinkedList<>());
        }

        for (int i=0;i<m;i++){
            stringTokenizer = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());
            int cost = Integer.parseInt(stringTokenizer.nextToken());
            graph.get(start).add(new Node(end, cost));
        }
        stringTokenizer = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(stringTokenizer.nextToken());
        int end = Integer.parseInt(stringTokenizer.nextToken());

        distance[start].cost = 0;
        queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()){
            Node node = queue.poll();
            int currentEnd = node.end;
            int currentCost = node.cost;

            if(distance[currentEnd].cost < currentCost){
                continue;
            }

            for (Node neighbor: graph.get(currentEnd)){
                int next = neighbor.end;
                int nextCost = neighbor.cost + currentCost;

                if(nextCost < distance[next].cost){
                    distance[next].cost = nextCost;
                    distance[next].nodes = new LinkedList<>(distance[currentEnd].nodes);
                    distance[next].nodes.add(currentEnd);
                    queue.add(new Node(next, nextCost));
                }
            }

        }

        distance[end].nodes.add(end);

        StringBuilder sb = new StringBuilder()
                .append(distance[end].cost)
                .append("\n")
                .append(distance[end].nodes.size())
                .append("\n");

        distance[end].nodes.forEach(i->sb.append(i+" "));

        System.out.println(sb);

    }

}