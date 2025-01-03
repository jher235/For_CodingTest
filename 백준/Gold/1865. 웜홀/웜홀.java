
import java.io.*;
import java.util.*;

public class Main {


    static int n;

    static int MAX = 987654321;

    static class Node{
        int end;
        int cost;

        public Node(int end, int cost){
            this.end = end;
            this.cost = cost;
        }
    }
    static List<Node>[] nodes;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        for (int i=0;i<tc;i++){
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine()," ");
            n = Integer.parseInt(stringTokenizer.nextToken());
            int m = Integer.parseInt(stringTokenizer.nextToken());
            int w = Integer.parseInt(stringTokenizer.nextToken());

            nodes = new List[n+1];
            for (int j=0;j<=n;j++){
                nodes[j] = new LinkedList<Node>();
            }

            for (int j=0;j<m + w;j++) {
                stringTokenizer = new StringTokenizer(br.readLine(), " ");
                int s = Integer.parseInt(stringTokenizer.nextToken());
                int e = Integer.parseInt(stringTokenizer.nextToken());
                int t = Integer.parseInt(stringTokenizer.nextToken());
                if (j < m) {
                    nodes[s].add(new Node(e, t));
                    nodes[e].add(new Node(s, t));
                } else {
                    nodes[s].add(new Node(e, -t));
                }

            }
            if(bellmanFord(1)){
                stringBuilder.append("YES\n");
            }else{
                stringBuilder.append("NO\n");
            }
        }
        System.out.println(stringBuilder);
    }

    public static boolean bellmanFord(int start){
        int[] dist = new int[n+1];
        Arrays.fill(dist, MAX);
        boolean update = false;
        dist[start] = 0;

        // 음의 사이클 방지하고자 n-1번 반복
        for (int i=0;i<n-1;i++){
            update = false;
            for (int j=1; j<=n; j++){
                for (Node node : nodes[j]){
                    if(dist[node.end] > dist[j] + node.cost){
                        dist[node.end] = dist[j] + node.cost;
                        update = true;
                    }
                }
            }
            if (!update) break;
        }

        //음의 사이클 검사
        if(update){ // 마지막까지 업데이트가 일어난 경우 한번 더 업데이트가 일어나는지 확인함. 업데이트가 일어나면 음의 사이클이 존재하는 것.
            for (int i=1;i<=n;i++){
                for (Node node: nodes[i]){
                    if(dist[node.end] > dist[i] + node.cost){
                        return true;
                    }
                }
            }
        }

        return false;
    }


}