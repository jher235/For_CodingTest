import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;


public class Main {

    static int n, m;

    static int[][] edge;

    static int MAX = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        edge = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if(edge[start][end] != 0){
                edge[start][end] = Math.min(edge[start][end], cost);
            }else {
                edge[start][end] = cost;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                edge[i][j] =  edge[i][j] == 0 ?
                        MAX :
                        edge[i][j];
            }
        }

        for (int k = 1; k <= n; k++){
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if(i==j){
                        continue;
                    }
                    edge[i][j] = Math.min(edge[i][j], edge[i][k] + edge[k][j]);
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            stringBuilder
                    .append(Arrays.stream(edge[i])
                            .skip(1)
                            .map(cost -> cost == MAX ? 0 : cost)
                            .mapToObj(String::valueOf)
                            .collect(Collectors.joining(" ")))
                    .append("\n");

        }

        System.out.println(stringBuilder);

    }
}