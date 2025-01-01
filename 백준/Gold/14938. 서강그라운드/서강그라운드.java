import java.io.*;
import java.util.*;

public class Main {

    static int MAX = 987654321;

    static int n, m, r;

    static int[][] graph;
    static int[] point;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());
        r = Integer.parseInt(stringTokenizer.nextToken());

        graph = new int[n+1][n+1];
        point = new int[n+1];

        stringTokenizer = new StringTokenizer(br.readLine(), " ");
        for (int i=1;i<=n;i++){
            point[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        for (int i=1;i<=n;i++){
            for (int j=1;j<=n;j++){
                if(i!=j){
                    graph[i][j] = MAX;
                }
            }
        }
        for (int i=0;i<r;i++){
            stringTokenizer = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());
            int cost = Integer.parseInt(stringTokenizer.nextToken());
            graph[start][end] = cost;
            graph[end][start] = cost;
        }


        for (int k=1; k<=n;k++){
            for (int i=1;i<=n;i++){
                for (int j=1;j<=n;j++){
                    if(graph[i][j] > graph[i][k] + graph[k][j]){
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }

        for (int i=1;i<=n;i++){
            int pointSum = 0;
            for (int j=1;j<=n;j++){
                if(graph[i][j] <= m){
                    pointSum += point[j];
                }
            }
            ans = Math.max(pointSum, ans);
        }

        System.out.println(ans);
    }

}