import java.io.*;
import java.util.*;
import java.util.stream.Stream;


public class Main {

    static int n, m, x;
    static int[][] bridge;

    // Integer.MAX_VALUE 사용시 오버플로우
    static int MAX_VALUE = 987654321;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());
        x = Integer.parseInt(stringTokenizer.nextToken());

        bridge = new int[n + 1][n + 1];

        for (int i=1;i<=n;i++){
            Arrays.fill(bridge[i], MAX_VALUE);
            bridge[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(br.readLine(), " ");
            int startPoint = Integer.parseInt(stringTokenizer.nextToken());
            int endPoint = Integer.parseInt(stringTokenizer.nextToken());
            int cost = Integer.parseInt(stringTokenizer.nextToken());

            bridge[startPoint][endPoint] = cost;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    bridge[i][j] = Math.min(bridge[i][j], bridge[i][k] + bridge[k][j]);
                }
            }
        }
        
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, bridge[i][x] + bridge[x][i]);
        }
        System.out.println(ans);
    }

}